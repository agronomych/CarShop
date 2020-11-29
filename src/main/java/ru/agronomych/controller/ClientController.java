package ru.agronomych.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.converters.CarDTOConverter;
import ru.agronomych.controller.dto.converters.ClientDTOConverter;
import ru.agronomych.model.CarModel;
import ru.agronomych.model.ClientModel;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.validator.ClientValidator;

import java.util.HashMap;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

/**
 * Контроллер для обработки запросов /clients
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    ClientService clientService;
    ClientValidator clientValidator;

    public ClientController(ClientService clientService,
                            ClientValidator clientValidator){
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    /**
     * получение клиента по id
     * @param id
     * @return объект DTO клиента
     */
    @GetMapping("/get/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id){
        return toDTO(clientService.getClientById(id));
    }

    /**
     * Возвращает список всех клиентов
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ClientDTO> getAllClients(){
        HashMap<Long, ClientDTO> mapDTO = new HashMap<>();
        HashMap<Long, ClientModel> mapModel = clientService.getAllClients();
        for (Long id:mapModel.keySet()) {
            mapDTO.put(id, toDTO(mapModel.get(id)));
        }
        return mapDTO;
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
        clientService.addClient(fromDTO(clientData));
        return clientData;
    }

    /**
     * удаляет клиента с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
    }

    /**
     * обновляет данные по клинету
     * @param clientData
     */
    @PutMapping(value = "/update/{id}")
    public String updateClient(@PathVariable("{id}") Long id, @RequestBody ClientDTO clientData, BindingResult result){
        if (clientData.getId() == id) {
            clientService.updateClient(fromDTO(clientData));
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
        return clientService.save();
    }

    /**
     * загружает клиентов из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadClients(){
        return clientService.load();
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
