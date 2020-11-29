package ru.agronomych.controller;

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

/**
 * Контроллер для обработки запросов /managers
 */
@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    ManagerService managerService;
    ManagerValidator managerValidator;

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
    @GetMapping("/get/{id}")
    public ManagerDTO getManager(@PathVariable("id") Long id){
        return toDTO(managerService.getManagerById(id));
    }

    /**
     * Возвращает список всех менеджеров
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ManagerDTO> getAllManagers(){
        HashMap<Long, ManagerDTO> mapDTO = new HashMap<>();
        HashMap<Long, ManagerModel> mapModel = managerService.getAllManagers();
        for (Long id:mapModel.keySet()) {
            mapDTO.put(id, toDTO(mapModel.get(id)));
        }
        return mapDTO;
    }

    /**
     * добавляет нового менеджера
     * @param managerData
     */
    @PostMapping("/add")
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
    @DeleteMapping(value = "/delete/{id}")
    public void deleteManagerById(@PathVariable("id") Long id){
        managerService.deleteManagerById(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData
     */
    @PutMapping(value = "/update/{id}")
    public String updateManager(@PathVariable("{id}") Long id, @RequestBody ManagerDTO managerData){
        if (managerData.getId() == id) {
            managerService.updateManager(fromDTO(managerData));
            return "Data is updated";
        } else {
            return "Wrong ID";
        }
    }

    /**
     * сорхраняет всех менеджеров в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveManagers(){
        return managerService.save();
    }

    /**
     * загружает менеджеров из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadManagers(){
        return managerService.load();
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
