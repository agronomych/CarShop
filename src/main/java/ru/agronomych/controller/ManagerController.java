package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.service.interfaces.ManagerService;
import ru.agronomych.validator.ManagerValidator;

import java.util.List;

/**
 * Контроллер для обработки запросов /api/v1/managers
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
    public ManagerDTO get(@PathVariable("id") Long id){
        return managerService.getById(id);
    }

    /**
     * Возвращает список всех менеджеров
     * @return список менеджеров
     */
    @GetMapping(value = "/")
    public List<ManagerDTO> getAll(){
        return managerService.getAll();
    }

    /**
     * добавляет нового менеджера
     * @param managerData данные менеджера
     */
    @PostMapping("/")
    public ManagerDTO add(@Validated @RequestBody ManagerDTO managerData, BindingResult result){

        if (result.hasErrors()){
            managerData.setErrors(result.getAllErrors());
            return managerData;
        }
        managerService.add(managerData);
        return managerData;
    }

    /**
     * удаляет менеджера с ключом id
     * @param id уникальный идентификатор
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id){
        managerService.deleteById(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData обновлённые данные
     * @param id уникальный идентификатор
     */
    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> update(@PathVariable("id") Long id, @RequestBody ManagerDTO managerData){
        if (managerData.getId().equals(id)) {
            managerService.update(managerData);
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
