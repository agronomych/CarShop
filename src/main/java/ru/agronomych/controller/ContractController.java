package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.exception.UnknownIdException;
import ru.agronomych.service.CarService;
import ru.agronomych.service.ClientService;
import ru.agronomych.service.ContractService;
import ru.agronomych.service.ManagerService;
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
    public ResponseEntity<ContractDTO> add(@Validated @RequestBody ContractDTO contractData, BindingResult result, UriComponentsBuilder uriBuilder){
        if (result.hasErrors()){
            throw new UnknownIdException(result);
        }
        contractService.add(contractData);
        return ResponseEntity.created(uriBuilder.path("/api/v1/contracts/" + contractData.getId()).buildAndExpand(contractData).toUri()).body(contractData);
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
