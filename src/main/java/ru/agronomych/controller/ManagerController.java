package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.controller.dto.services.ManagerDTOService;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /managers
 */
@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    @Autowired
    ManagerDTOService managerDTO;

    /**
     * получение менеджера по id
     * @param id
     * @return объект DTO менеджера
     */
    @GetMapping("/get")
    public ManagerDTO getManager(@RequestParam Long id){
        return managerDTO.get(id);
    }

    /**
     * Возвращает список всех менеджеров
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<Long,ManagerDTO> getAllManagers(){
        return managerDTO.getAll();
    }

    /**
     * добавляет нового менеджера
     * @param managerData
     */
    @PostMapping("/add")
    public void addManager(@RequestBody ManagerDTO managerData){
        managerDTO.add(managerData);
    }

    /**
     * удаляет менеджера с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteManagerById(@PathVariable Long id){
        managerDTO.delete(id);
    }

    /**
     * обновляет данные по менеджеру
     * @param managerData
     */
    @PutMapping(value = "/update")
    public void updateManager(@RequestBody ManagerDTO managerData){
        managerDTO.update(managerData);
    }

    /**
     * сорхраняет всех менеджеров в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveManagers(){
        return managerDTO.save();
    }

    /**
     * загружает менеджеров из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadManagers(){
        return managerDTO.load();
    }
}
