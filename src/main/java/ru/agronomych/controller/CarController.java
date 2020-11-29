package ru.agronomych.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.model.CarModel;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.validator.CarValidator;
import static ru.agronomych.controller.dto.converters.CarDTOConverter.*;

import java.util.HashMap;

/**
 * Контроллер для обработки запросов /cars
 */
@RestController
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;
    private CarValidator carValidator;

    public CarController(CarService carService,
                         CarValidator carValidator){
        this.carService = carService;
        this.carValidator = carValidator;
    }

    /**
     * получение автомобиля по id
     * @param id
     * @return объект DTO автомобиля
     */
    @GetMapping("/get/{id}")
    public CarDTO getCar(@PathVariable("id") String id){
        return toDTO(carService.getCarById(id));
    }

    /**
     * Возвращает список всех автомобилей
     * @return
     */
    @GetMapping(value = "/getAll")
    public HashMap<String,CarDTO> getAllCars(){
        HashMap<String,CarDTO> mapDTO = new HashMap<>();
        HashMap<String,CarModel> mapModel = carService.getAllCars();
        for (String id:mapModel.keySet()) {
            mapDTO.put(id,toDTO(mapModel.get(id)));
        }
        return mapDTO;
    }

    /**
     * добавляет новый автомобиль
     * @param carData
     */
    @PostMapping("/add")
    public CarDTO addCar(@Validated @RequestBody CarDTO carData, BindingResult result){
        if (result.hasErrors()){
            carData.setErrors(result.getAllErrors());
            return carData;
        }
        carService.addCar(fromDTO(carData));
        return carData;
    }

    /**
     * удаляет автомобиль с ключом id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteCarById(@PathVariable("id") String id){
        carService.deleteCarById(id);
    }

    /**
     * обновляет данные по автомобилю
     * @param carData
     */
    @PutMapping(value = "/update/{id}")
    public String updateCar(@PathVariable("{id}") String id, @Validated @RequestBody CarDTO carData, BindingResult result){
        if (carData.getId().equals(id)) {
            carService.updateCar(fromDTO(carData));
            return "Data is updated";
        } else {
            return "Wrong ID";
        }
    }

    /**
     * сорхраняет все автомобили в файл
     * @return
     */
    @GetMapping(value = "/save")
    public String saveCars(){
        return carService.save();
    }

    /**
     * загружает автомобили из файлов
     * @return
     */
    @GetMapping(value = "/load")
    public String loadCars(){
        return carService.load();
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
