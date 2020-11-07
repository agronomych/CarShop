package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.services.CarDTOService;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /cars
 */
@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarDTOService carDTOservice;

    /**
     * получение автомобиля по id
     * @param id
     * @return объект DTO автомобиля
     */
    @GetMapping("/get")
    public CarDTO getCar(@RequestParam String id){
        return carDTOservice.get(id);
    }

    /**
     * Возвращает список всех автомобилей
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<String,CarDTO> getAllCars(){
        return carDTOservice.getAll();
    }

    /**
     * добавляет новый автомобиль
     * @param carData
     */
    @PostMapping("/add")
    public void addCar(@RequestBody String carData){
        CarDTO car = (new Gson()).fromJson(carData,CarDTO.class);
        carDTOservice.add(car);
    }

    /**
     * удаляет автомобиль с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteCarById(@PathVariable String id){
        carDTOservice.delete(id);
    }

    /**
     * обновляет данные по автомобилю
     * @param carData
     */
    @PutMapping(value = "/update")
    public void updateCar(@RequestBody String carData){
        carDTOservice.update((new Gson()).fromJson(carData,CarDTO.class));
    }

    /**
     * сорхраняет все автомобили в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveCars(){
        return carDTOservice.save();
    }

    /**
     * загружает автомобили из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadCars(){
        return carDTOservice.load();
    }
}
