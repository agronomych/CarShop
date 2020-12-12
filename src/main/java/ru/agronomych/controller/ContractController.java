package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;
import ru.agronomych.validator.ContractValidator;

import java.util.List;

/**
 * Контроллер для обработки запросов с корневым контекстом /api/v1/contracts
 */
@RestController
@RequestMapping(value = "/api/v1/contracts")
public class ContractController {

    private ContractService contractService;
    private ContractValidator contractValidator;
    private CarService carService;
    private ClientService clientService;
    private ManagerService managerService;


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
     * @param id уникальный идентификатор
     * @return объект DTO контракта
     */
    @GetMapping("/{id}")
    public ContractDTO get(@PathVariable("id") Long id){
        return contractService.getById(id);
    }

    /**
     * Возвращает список всех контрактов
     * @return список контрактов
     */
    @GetMapping("/")
    public List<ContractDTO> getAll(){
        return contractService.getAll();
    }

    /**
     * добавляет новый контракт
     * @param contractData данные контракта
     */
    @PostMapping("/")
    public ContractDTO add(@Validated @RequestBody ContractDTO contractData, BindingResult result){
        if (result.hasErrors()){
            contractData.setErrors(result.getAllErrors());
            return contractData;
        }
        contractService.add(contractData);
        return contractData;
    }

    /**
     * удаляет контракт с ключом id
     * @param id уникальный идентификатор
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id){
        contractService.deleteById(id);
    }

    /**
     * обновляет данные по контракту с идентификатором id
     * @param contractData обновлённые данные контракта
     * @param id уникальный идентификатор
     */
    @PutMapping("/{id}")
    public ResponseEntity<ContractDTO> update(@PathVariable("id") Long id, @RequestBody ContractDTO contractData){
        if (contractData.getId().equals(id)) {
            contractService.update(contractData);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(contractData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(contractData);
        }
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
