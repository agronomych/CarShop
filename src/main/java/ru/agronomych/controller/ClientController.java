package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.services.ClientDTOService;
import ru.agronomych.controller.dto.services.ClientDTOService;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientDTOService clientDTO;

    @GetMapping("/get")
    public ClientDTO getClient(@RequestParam String id){
        return clientDTO.get(id);
    }

    @GetMapping(value = "/getAll")
    public HashMap<String,ClientDTO> getAllClients(){
        return clientDTO.getAll();
    }

    @PostMapping("/add")
    public void addClient(@RequestBody String clientData){
        clientDTO.add((new Gson()).fromJson(clientData, ClientDTO.class));
    }

    @DeleteMapping(value = "/delete")
    public void deleteClientById(@RequestParam String id){
        clientDTO.delete(id);
    }

    @PutMapping(value = "/update")
    public void updateClient(@RequestBody String clientData){
        clientDTO.update((new Gson()).fromJson(clientData, ClientDTO.class));
    }

    @GetMapping(value = "/save")
    public String saveClients(){
        return clientDTO.save();
    }

    @GetMapping(value = "/load")
    public String loadClients(){
        return clientDTO.load();
    }
}
