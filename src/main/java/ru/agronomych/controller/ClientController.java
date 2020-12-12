package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.validator.ClientValidator;

import java.util.List;

/**
 * Контроллер для обработки запросов /api/v1/clients
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
     * @param id уникальный идентификатор
     * @return объект DTO клиента
     */
    @GetMapping("/{id}")
    public ClientDTO get(@PathVariable("id") Long id){
        return clientService.getById(id);
    }

    /**
     * Возвращает список всех клиентов
     * @return список клиентов
     */
    @GetMapping(value = "/")
    public List<ClientDTO> getAll(){
        return clientService.getAll();
    }

    /**
     * добавляет нового клиента
     * @param clientData данные нового клиента
     */
    @PostMapping("/")
    public ClientDTO add(@Validated @RequestBody ClientDTO clientData, BindingResult result){
        if (result.hasErrors()){
            clientData.setErrors(result.getAllErrors());
            return clientData;
        }
        clientService.add(clientData);
        return clientData;
    }

    /**
     * удаляет клиента с ключом id
     * @param id уникальный идентификатор
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id){
        clientService.deleteById(id);
    }

    /**
     * обновляет данные по клинету с идентификатором id
     * @param clientData обновлённые данные
     * @param id уникальный идентификатор
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable("id") Long id, @RequestBody ClientDTO clientData, BindingResult result){
        if (clientData.getId().equals(id)) {
            clientService.update(clientData);
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
