package ru.agronomych.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.controller.dto.services.CarDTOService;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarDTOService carDTOservice;

    @GetMapping("/get")
    public CarDTO getCar(@RequestParam String id){
        return carDTOservice.get(id);
    }

    @GetMapping(value = "/getAll")
    public HashMap<String,CarDTO> getAllCars(){
        return carDTOservice.getAll();
    }

    @PostMapping("/add")
    public void addCar(@RequestBody String carData){
        CarDTO car = (new Gson()).fromJson(carData,CarDTO.class);
        carDTOservice.add(car);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCarById(@RequestParam String id){
        carDTOservice.delete(id);
    }

    @PutMapping(value = "/update")
    public void updateCar(@RequestBody String carData){
        carDTOservice.update((new Gson()).fromJson(carData,CarDTO.class));
    }

    @GetMapping(value = "/save")
    public String saveCars(){
        return carDTOservice.save();
    }

    @GetMapping(value = "/load")
    public String loadCars(){
        return carDTOservice.load();
    }
}
