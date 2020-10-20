package ru.Agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.Agronomych.dao.interfaces.CarDAO;
import ru.Agronomych.model.CarModel;
import ru.Agronomych.service.interfaces.CarService;

import java.util.HashMap;

@Service(value = "CarService")
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    /**
     * Добавить автомобиль
     */
    @Override
    public void addCar(CarModel car) {
        carDAO.save(car);
    }

    /**
     * Добавить список автомобилей
     */
    @Override
    public void addAllCars(HashMap<String, CarModel> map) {
        carDAO.addAll(map);
    }

    /**
     * Получить список всех автомобилей
     */
    @Override
    public HashMap<String, CarModel> getAllCars() {
        return (HashMap<String, CarModel>) carDAO.getAll();
    }
}
