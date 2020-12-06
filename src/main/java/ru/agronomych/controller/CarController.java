package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Контроллер для обработки запросов /cars
 */
@RestController
@RequestMapping(value = "/api/v1/cars")
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
    @GetMapping("/{id}")
    public CarDTO getCar(@PathVariable("id") String id){
        return toDTO(carService.getCarById(id));
    }

    /**
     * Возвращает список всех автомобилей
     * @return
     */
    @GetMapping("/")
    public List<CarDTO> getAllCars(){
        List<CarDTO> listDTO = new LinkedList<>();
        HashMap<String,CarModel> mapModel = carService.getAllCars();
        for (String id:mapModel.keySet()) {
            listDTO.add(toDTO(mapModel.get(id)));
        }
        return listDTO;
    }

    /**
     * добавляет новый автомобиль
     * @param carData
     */
    @PostMapping("/")
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
    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") String id){
        carService.deleteCarById(id);
    }

    /**
     * обновляет данные по автомобилю
     * @param carData
     */
    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable("id") String id, @Validated @RequestBody CarDTO carData, BindingResult result){
        if (carData.getId().equals(id)) {
            carService.updateCar(fromDTO(carData));
            return ResponseEntity.status(HttpStatus.OK).body(carData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(carData);
        }
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
