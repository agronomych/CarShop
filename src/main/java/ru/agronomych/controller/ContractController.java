package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.services.ContractDTOService;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /contracts
 */
@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    ContractDTOService contractDTO;

    /**
     * получение контракта по id
     * @param id
     * @return объект DTO контракта
     */
    @GetMapping("/get")
    public ContractDTO getContract(@RequestParam Long id){
        return contractDTO.get(id);
    }

    /**
     * Возвращает список всех контрактов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ContractDTO> getAllContracts(){
        return contractDTO.getAll();
    }

    /**
     * добавляет новый контракт
     * @param contractData
     */
    @PostMapping("/add")
    public void addContract(@RequestBody String contractData){
        contractDTO.add((new Gson()).fromJson(contractData, ContractDTO.class));
    }

    /**
     * удаляет контракт с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteContractById(@PathVariable Long id){
        contractDTO.delete(id);
    }

    /**
     * обновляет данные по контракту
     * @param contractData
     */
    @PutMapping(value = "/update")
    public void updateContract(@RequestBody String contractData){
        contractDTO.update((new Gson()).fromJson(contractData, ContractDTO.class));
    }

    /**
     * сорхраняет все контракты в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveContracts(){
        return contractDTO.save();
    }

    /**
     * загружает контракты из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadContracts(){
        return contractDTO.load();
    }
}
