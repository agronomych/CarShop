package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.services.CarDTOService;
import ru.agronomych.validator.CarValidator;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /cars
 */
@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarDTOService carDTOservice;

    @Autowired
    private CarValidator carValidator;

    /**
     * получение автомобиля по id
     * @param id
     * @return объект DTO автомобиля
     */
    @GetMapping("/get/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CarDTO getCar(@PathVariable("id") String id){
        return carDTOservice.get(id);
    }

    /**
     * Возвращает список всех автомобилей
     * @return
     */
    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public HashMap<String,CarDTO> getAllCars(){
        return carDTOservice.getAll();
    }

    /**
     * добавляет новый автомобиль
     * @param carData
     */
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CarDTO addCar(@Validated @RequestBody CarDTO carData, BindingResult result){
        if (result.hasErrors()){
            carData.setErrors(result.getAllErrors());
            return carData;
        }
        carDTOservice.add(carData);
        return carData;
    }

    /**
     * удаляет автомобиль с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCarById(@PathVariable("id") String id){
        carDTOservice.delete(id);
    }

    /**
     * обновляет данные по автомобилю
     * @param carData
     */
    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public CarDTO updateCar(@Validated @RequestBody CarDTO carData, BindingResult result){
        if (result.hasErrors()){
            carData.setErrors(result.getAllErrors());
            return carData;
        }
        carDTOservice.update(carData);
        return carData;
    }

    /**
     * сорхраняет все автомобили в файл
     * @return
     */
    @GetMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.OK)
    public String saveCars(){
        return carDTOservice.save();
    }

    /**
     * загружает автомобили из файлов
     * @return
     */
    @GetMapping(value = "/load")
    @ResponseStatus(value = HttpStatus.OK)
    public String loadCars(){
        return carDTOservice.load();
    }

    @ModelAttribute
    public CarDTO carDTO(){
        return new CarDTO();
    }

    @InitBinder(value = "carDTO")
    private void initBinder(WebDataBinder binder){
        binder.setValidator(carValidator);
    }
}
