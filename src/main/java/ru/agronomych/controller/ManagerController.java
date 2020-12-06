package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.model.ManagerModel;
import ru.agronomych.service.interfaces.ManagerService;
import ru.agronomych.validator.ManagerValidator;

import static ru.agronomych.controller.dto.converters.ManagerDTOConverter.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Контроллер для обработки запросов /managers
 */
@RestController
@RequestMapping(value = "/api/v1/managers")
public class ManagerController {

    private ManagerService managerService;
    private ManagerValidator managerValidator;

    public ManagerController(ManagerService managerService,
                             ManagerValidator managerValidator){
        this.managerService = managerService;
        this.managerValidator = managerValidator;
    }
    /**
     * получение менеджера по id
     * @param id
     * @return объект DTO менеджера
     */
    @GetMapping("/{id}")
    public ManagerDTO getManager(@PathVariable("id") Long id){
        return toDTO(managerService.getManagerById(id));
    }

    /**
     * Возвращает список всех менеджеров
     * @return
     */
    @GetMapping(value = "/")
    public List<ManagerDTO> getAllManagers(){
        List<ManagerDTO> listDTO = new LinkedList<>();
        HashMap<Long, ManagerModel> mapModel = managerService.getAllManagers();
        for (Long id:mapModel.keySet()) {
            listDTO.add(toDTO(mapModel.get(id)));
        }
        return listDTO;
    }

    /**
     * добавляет нового менеджера
     * @param managerData
     */
    @PostMapping("/")
    public ManagerDTO addManager(@Validated @RequestBody ManagerDTO managerData, BindingResult result){

        if (result.hasErrors()){
            managerData.setErrors(result.getAllErrors());
            return managerData;
        }
        managerService.addManager(fromDTO(managerData));
        return managerData;
    }

    /**
     * удаляет менеджера с ключом id
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteManagerById(@PathVariable("id") Long id){
        managerService.deleteManagerById(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData
     */
    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> updateManager(@PathVariable("id") Long id, @RequestBody ManagerDTO managerData){
        if (managerData.getId() == id) {
            managerService.updateManager(fromDTO(managerData));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(managerData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(managerData);
        }
    }

    @ModelAttribute
    public ManagerDTO managerDTO(){
        return new ManagerDTO();
    }

    @InitBinder(value = "managerDTO")
    private void initBinder(WebDataBinder binder){
        binder.setValidator(managerValidator);
    }
}
