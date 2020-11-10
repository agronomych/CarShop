package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.services.ContractDTOService;
import ru.agronomych.validator.ContractValidator;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /contracts
 */
@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    ContractDTOService contractDTOService;

    @Autowired
    ContractValidator contractValidator;
    /**
     * получение контракта по id
     * @param id
     * @return объект DTO контракта
     */
    @GetMapping("/get/{id}")
    public ContractDTO getContract(@PathVariable("id") Long id){
        return contractDTOService.get(id);
    }

    /**
     * Возвращает список всех контрактов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ContractDTO> getAllContracts(){
        return contractDTOService.getAll();
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
        contractDTOService.add(contractData);
        return contractData;
    }

    /**
     * удаляет контракт с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteContractById(@PathVariable("id") Long id){
        contractDTOService.delete(id);
    }

    /**
     * обновляет данные по контракту
     * @param contractData
     */
    @PutMapping(value = "/update")
    public void updateContract(@RequestBody ContractDTO contractData){
        contractDTOService.update(contractData);
    }

    /**
     * сорхраняет все контракты в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveContracts(){
        return contractDTOService.save();
    }

    /**
     * загружает контракты из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadContracts(){
        return contractDTOService.load();
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
