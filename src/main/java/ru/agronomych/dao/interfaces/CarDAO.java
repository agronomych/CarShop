package ru.agronomych.dao.interfaces;

import ru.agronomych.model.Car;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Автомобиль
 */
public interface CarDAO extends CommonDAO<Car, String> {

    /**
     * получаем списко автомобилей конкретной модели
     * @param model
     */
    HashMap<Car,String> getCarsByModel(String model);

}
