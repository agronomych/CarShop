package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

/**
 * Контроллер для обработки запросов /clients
 */
@RestController
@RequestMapping(value = "/api/v1/clients")
public class ClientController {

    private ClientService clientService;
    private ClientValidator clientValidator;

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
    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id){
        return toDTO(clientService.getClientById(id));
    }

    /**
     * Возвращает список всех клиентов
     * @return
     */
    @GetMapping(value = "/")
    public List<ClientDTO> getAllClients(){
        List<ClientDTO> listDTO = new LinkedList<>();
        HashMap<Long, ClientModel> mapModel = clientService.getAllClients();
        for (Long id:mapModel.keySet()) {
            listDTO.add(toDTO(mapModel.get(id)));
        }
        return listDTO;
    }

    /**
     * добавляет нового клиента
     * @param clientData
     */
    @PostMapping("/")
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
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
    }

    /**
     * обновляет данные по клинету
     * @param clientData
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO clientData, BindingResult result){
        if (clientData.getId() == id) {
            clientService.updateClient(fromDTO(clientData));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clientData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clientData);
        }
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
