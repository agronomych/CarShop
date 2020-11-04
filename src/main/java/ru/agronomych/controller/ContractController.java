package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.services.ContractDTOService;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    ContractDTOService contractDTO;

    @GetMapping("/get")
    public ContractDTO getContract(@RequestParam Long id){
        return contractDTO.get(id);
    }

    @GetMapping(value = "/getAll")
    public HashMap<Long,ContractDTO> getAllContracts(){
        return contractDTO.getAll();
    }

    @PostMapping("/add")
    public void addContract(@RequestBody String contractData){
        contractDTO.add((new Gson()).fromJson(contractData, ContractDTO.class));
    }

    @DeleteMapping(value = "/delete")
    public void deleteContractById(@RequestParam Long id){
        contractDTO.delete(id);
    }

    @PutMapping(value = "/update")
    public void updateContract(@RequestBody String contractData){
        contractDTO.update((new Gson()).fromJson(contractData, ContractDTO.class));
    }

    @GetMapping(value = "/save")
    public String saveContracts(){
        return contractDTO.save();
    }

    @GetMapping(value = "/load")
    public String loadContracts(){
        return contractDTO.load();
    }
}
