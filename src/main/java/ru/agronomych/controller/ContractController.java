package ru.agronomych.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.model.ContractModel;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;
import ru.agronomych.validator.ContractValidator;

import static ru.agronomych.controller.dto.converters.ContractDTOConverter.*;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов с корневым контекстом /contracts
 */
@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    ContractService contractService;
    ContractValidator contractValidator;
    CarService carService;
    ClientService clientService;
    ManagerService managerService;


    public ContractController(ContractService contractService,
                              ContractValidator contractValidator,
                              CarService carService,
                              ManagerService managerService,
                              ClientService clientService){
        this.contractService = contractService;
        this.contractValidator = contractValidator;
        this.carService = carService;
        this.clientService = clientService;
        this.managerService = managerService;
    }
    /**
     * получение контракта по id
     * @param id
     * @return объект DTO контракта
     */
    @GetMapping("/get/{id}")
    public ContractDTO getContract(@PathVariable("id") Long id){
        ContractModel contract = contractService.getContractById(id);
        return toDTO(   contract,
                        contract.getCar().getId(),
                        contract.getClient().getId(),
                        contract.getManager().getId()
                );
    }

    /**
     * Возвращает список всех контрактов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ContractDTO> getAllContracts(BindingResult result){
        if (result.hasErrors()){
            return null;
        }
        HashMap<Long, ContractDTO> mapDTO = new HashMap<>();
        HashMap<Long, ContractModel> mapModel = contractService.getAllContracts();
        for (Long id:mapModel.keySet()) {
            ContractModel contract = mapModel.get(id);
            mapDTO.put(id, toDTO(   contract,
                                    contract.getCar().getId(),
                                    contract.getClient().getId(),
                                    contract.getManager().getId()));
        }
        return mapDTO;
    }

    /**
     * добавляет новый контракт
     * @param contractData
     */
    @PostMapping("/add")
    public ContractDTO addContract(@Validated @RequestBody ContractDTO contractData, BindingResult result){
        if (result.hasErrors()){
            contractData.setErrors(result.getAllErrors());
            return contractData;
        }
        contractService.addContract(fromDTO(contractData,
                                            carService.getCarById(contractData.getCarId()),
                                            clientService.getClientById(contractData.getClientId()),
                                            managerService.getManagerById(contractData.getManagerId())));
        return contractData;
    }

    /**
     * удаляет контракт с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteContractById(@PathVariable("id") Long id){
        contractService.deleteContractById(id);
    }

    /**
     * обновляет данные по контракту
     * @param contractData
     */
    @PutMapping(value = "/update/{id}")
    public String updateContract(@PathVariable("{id}") Long id, @RequestBody ContractDTO contractData){
        if (contractData.getId() == id) {
            contractService.updateContract(fromDTO(contractData,
                    carService.getCarById(contractData.getCarId()),
                    clientService.getClientById(contractData.getClientId()),
                    managerService.getManagerById(contractData.getManagerId())));
            return "Data is updated";
        } else {
            return "Wrong ID";
        }
    }

    /**
     * сорхраняет все контракты в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveContracts(){
        return contractService.save();
    }

    /**
     * загружает контракты из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadContracts(){
        return contractService.load();
    }

    @ModelAttribute
    public ContractDTO contractDTO(){
        return new ContractDTO();
    }

    @InitBinder(value = "contractDTO")
    private void initBinder(WebDataBinder binder){
        binder.setValidator(contractValidator);
    }
}
