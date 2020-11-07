package ru.agronomych.controller.dto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.model.CarModel;
import ru.agronomych.service.interfaces.CarService;

import java.io.*;
import java.util.HashMap;

/**
 * сервис для работы со слоем DTO сущности Автомобиль
 */

@Service
@PropertySource(value = {"classpath:application.properties"})
public class CarDTOService implements DTOService<CarDTO,CarModel,String>{

    @Autowired
    CarService carService;

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.cars}")
    private String filename;

    @Override
    public CarModel fromDTO(CarDTO carDTO){
        CarModel car = new CarModel();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        return car;
    }

    @Override
    public CarDTO toDTO(CarModel car){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        return carDTO;
    }

    @Override
    public void add(CarDTO carData){
        carService.addCar(fromDTO(carData));
    }

    @Override
    public CarDTO get(String id){
        return toDTO(carService.getCarById(id));
    }

    @Override
    public HashMap<String,CarDTO> getAll(){
        HashMap<String,CarDTO> map = new HashMap<>();
        HashMap<String,CarModel> mapModels;
        mapModels = carService.getAllCars();
        for (CarModel car:mapModels.values()) {
            map.put(car.getId(),toDTO(car));
        }
        return map;
    }

    @Override
    public void delete(String id){
        carService.deleteCarById(id);
    }

    @Override
    public void update(CarDTO car){
        carService.updateCar(fromDTO(car));
    }

    @Override
    public String save(){
        try {
            HashMap<String,CarDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(CarModel car:carService.getAllCars().values()){
                map.put(car.getId(),toDTO(car));
            }
            output.writeObject(map);
            output.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return "Something is wrong with I/O";
        }
        return "Cars are saved correctly";
    }

    @Override
    public String load(){
        try {
            HashMap<String,CarDTO> map;
            FileInputStream inputStream = new FileInputStream(dbPath+"/"+filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            map  = (HashMap<String,CarDTO>)input.readObject();
            for(CarDTO car:map.values()){
                carService.addCar(fromDTO(car));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Cars are loaded correctly";
    }
}
