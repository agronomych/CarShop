package ru.agronomych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.controller.dto.services.ManagerDTOService;
import ru.agronomych.validator.ManagerValidator;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /managers
 */
@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    @Autowired
    ManagerDTOService managerDTOService;

    @Autowired
    ManagerValidator managerValidator;
    /**
     * получение менеджера по id
     * @param id
     * @return объект DTO менеджера
     */
    @GetMapping("/get/{id}")
    public ManagerDTO getManager(@PathVariable("id") Long id){
        return managerDTOService.get(id);
    }

    /**
     * Возвращает список всех менеджеров
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ManagerDTO> getAllManagers(){
        return managerDTOService.getAll();
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
        managerDTOService.add(managerData);
        return managerData;
    }

    /**
     * удаляет менеджера с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteManagerById(@PathVariable("id") Long id){
        managerDTOService.delete(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData
     */
    @PutMapping(value = "/update")
    public void updateManager(@RequestBody ManagerDTO managerData){
        managerDTOService.update(managerData);
    }

    /**
     * сорхраняет всех менеджеров в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveManagers(){
        return managerDTOService.save();
    }

    /**
     * загружает менеджеров из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadManagers(){
        return managerDTOService.load();
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
