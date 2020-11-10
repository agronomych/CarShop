package ru.agronomych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
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
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerDTO getManager(@PathVariable Long id){
        return managerDTOService.get(id);
    }

    /**
     * Возвращает список всех менеджеров
     * @return
     */
    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public HashMap<Long,ManagerDTO> getAllManagers(){
        return managerDTOService.getAll();
    }

    /**
     * добавляет нового менеджера
     * @param managerData
     */
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
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
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteManagerById(@PathVariable Long id){
        managerDTOService.delete(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData
     */
    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateManager(@RequestBody ManagerDTO managerData){
        managerDTOService.update(managerData);
    }

    /**
     * сорхраняет всех менеджеров в файл
     * @return
     */
    @GetMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.OK)
    //@Async
    public String saveManagers(){
        return managerDTOService.save();
    }

    /**
     * загружает менеджеров из файлов
     * @return
     */
    @GetMapping(value = "/load")
    @ResponseStatus(value = HttpStatus.OK)
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
