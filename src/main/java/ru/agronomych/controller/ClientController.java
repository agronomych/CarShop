package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.services.ClientDTOService;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /clients
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientDTOService clientDTO;

    /**
     * получение клиента по id
     * @param id
     * @return объект DTO клиента
     */
    @GetMapping("/get")
    public ClientDTO getClient(@RequestParam Long id){
        return clientDTO.get(id);
    }

    /**
     * Возвращает список всех клиентов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ClientDTO> getAllClients(){
        return clientDTO.getAll();
    }

    /**
     * добавляет нового клиента
     * @param clientData
     */
    @PostMapping("/add")
    public void addClient(@RequestBody String clientData){
        clientDTO.add((new Gson()).fromJson(clientData, ClientDTO.class));
    }

    /**
     * удаляет клиента с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteClientById(@PathVariable Long id){
        clientDTO.delete(id);
    }

    /**
     * обновляет данные по клинету
     * @param clientData
     */
    @PutMapping(value = "/update")
    public void updateClient(@RequestBody String clientData){
        clientDTO.update((new Gson()).fromJson(clientData, ClientDTO.class));
    }

    /**
     * сорхраняет всех клиентов в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveClients(){
        return clientDTO.save();
    }

    /**
     * загружает клиентов из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadClients(){
        return clientDTO.load();
    }
}
