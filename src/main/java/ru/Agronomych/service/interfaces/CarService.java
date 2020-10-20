package ru.Agronomych.service.interfaces;

import ru.Agronomych.model.CarModel;

import java.util.HashMap;

/**
 * Сервис работоы с автомобилем
 *
 * @author Anton_Suryapin
 */
public interface CarService {

    public void addCar(CarModel car);

    public  void addAllCars(HashMap<String, CarModel> map);

    public HashMap<String, CarModel> getAllCars();
}
