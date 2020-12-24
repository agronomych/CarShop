package ru.agronomych.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.service.CarService;
import ru.agronomych.validator.CarValidator;

import java.util.List;

/**
 * Контроллер для обработки запросов /api/v1/cars
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
     * @param id - уникальный идентификатор
     * @return объект DTO автомобиля
     */
    @GetMapping("/{id}")
    public CarDTO get(@PathVariable("id") String id){
        return carService.getById(id);
    }

    /**
     * Возвращает список всех автомобилей
     * @return список автомобилей
     */
    @GetMapping("/")
    public List<CarDTO> getAll(){
        return carService.getAll();
    }

    /**
     * добавляет новый автомобиль
     * @param carData данные автомобиля
     */
    @PostMapping("/")
    public ResponseEntity<CarDTO> add(@Validated @RequestBody CarDTO carData, BindingResult result, UriComponentsBuilder uriBuilder){
        if (result.hasErrors()){
            carData.setErrors(result.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(carData);
        }
        carService.add(carData);
        return ResponseEntity.created(uriBuilder.path("/api/v1/cars/" + carData.getId()).buildAndExpand(carData).toUri()).body(carData);
    }

    /**
     * удаляет автомобиль с ключом id
     * @param id уникальный идентификатор
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        carService.deleteById(id);
    }

    /**
     * обновляет данные по автомобилю с уникальный идентификатором id
     * @param carData обновлённые данные
     * @param id уникальный идентификатор
     */
    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(@PathVariable("id") String id, @Validated @RequestBody CarDTO carData, BindingResult result){
        if (carData.getId().equals(id)) {
            carService.update(carData);
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
