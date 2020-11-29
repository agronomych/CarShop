package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.model.CarModel;
import ru.agronomych.service.interfaces.CarService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import static ru.agronomych.controller.dto.converters.CarDTOConverter.*;

@Service(value = "CarService")
@PropertySource(value = {"classpath:application.properties"})
public class CarServiceImpl implements CarService {

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.cars}")
    private String filename;

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addCar(CarModel car) {
        carDAO.save(car);
    }

    @Override
    public void addAllCars(HashMap<String, CarModel> map) {
        carDAO.addAll(map);
    }

    @Override
    public HashMap<String, CarModel> getAllCars() {
        return (HashMap<String, CarModel>) carDAO.getAll();
    }

    @Override
    public CarModel getCarById(String id) {
        return carDAO.getByPK(id);
    }

    @Override
    public void deleteCarById(String id) {
        carDAO.deleteByPK(id);
    }

    @Override
    public void updateCar(CarModel car) {
        carDAO.update(car);
    }

    @Override
    public String save(){
        try {
            HashMap<String, CarDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(CarModel car:this.getAllCars().values()){
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
                this.addCar(fromDTO(car));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Cars are loaded correctly";
    }
}
