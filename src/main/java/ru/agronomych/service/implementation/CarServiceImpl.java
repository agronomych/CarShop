package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.model.CarModel;
import ru.agronomych.service.interfaces.CarService;

import java.util.HashMap;

@Service(value = "CarService")
public class CarServiceImpl implements CarService {

    @Autowired
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
}
