package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.controller.dto.services.ManagerDTOService;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/managers")
public class ManagerController {


    @Autowired
    ManagerDTOService managerDTO;

    @GetMapping("/get")
    public ManagerDTO getManager(@RequestParam Long id){
        return managerDTO.get(id);
    }

    @GetMapping(value = "/getAll")
    public HashMap<Long,ManagerDTO> getAllManagers(){
        return managerDTO.getAll();
    }

    @PostMapping("/add")
    public void addManager(@RequestBody String managerData){
        managerDTO.add((new Gson()).fromJson(managerData, ManagerDTO.class));
    }

    @DeleteMapping(value = "/delete")
    public void deleteManagerById(@RequestParam Long id){
        managerDTO.delete(id);
    }

    @PutMapping(value = "/update")
    public void updateManager(@RequestBody ManagerDTO managerData){
        managerDTO.update(managerData);
    }

    @GetMapping(value = "/save")
    public String saveManagers(){
        return managerDTO.save();
    }

    @GetMapping(value = "/load")
    public String loadManagers(){
        return managerDTO.load();
    }
}
