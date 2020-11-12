package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.services.ClientDTOService;
import ru.agronomych.validator.ClientValidator;

import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Контроллер для обработки запросов /clients
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientDTOService clientDTOService;

    @Autowired
    ClientValidator clientValidator;

    /**
     * получение клиента по id
     * @param id
     * @return объект DTO клиента
     */
    @GetMapping("/get/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id){
        return clientDTOService.get(id);
    }

    /**
     * Возвращает список всех клиентов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ClientDTO> getAllClients(){
        return clientDTOService.getAll();
    }

    /**
     * добавляет нового клиента
     * @param clientData
     */
    @PostMapping("/add")
    public ClientDTO addClient(@Validated @RequestBody ClientDTO clientData, BindingResult result){
        if (result.hasErrors()){
            clientData.setErrors(result.getAllErrors());
            return clientData;
        }
        clientDTOService.add(clientData);
        return clientData;
    }

    /**
     * удаляет клиента с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteClientById(@PathVariable("id") Long id){
        clientDTOService.delete(id);
    }

    /**
     * обновляет данные по клинету
     * @param clientData
     */
    @PutMapping(value = "/update/{id}")
    public String updateClient(@PathVariable("{id}") Long id, @RequestBody ClientDTO clientData, BindingResult result){
        if (clientData.getId() == id) {
            clientDTOService.update(clientData);
            return "Data is updated";
        } else {
            return "Wrong ID";
        }
    }

    /**
     * сорхраняет всех клиентов в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveClients(){
        return clientDTOService.save();
    }

    /**
     * загружает клиентов из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadClients(){
        return clientDTOService.load();
    }

    @ModelAttribute
    public ClientDTO clientDTO(){
        return new ClientDTO();
    }

    @InitBinder(value = "clientDTO")
    private void initBinder(WebDataBinder binder){
        binder.setValidator(clientValidator);
    }
}
