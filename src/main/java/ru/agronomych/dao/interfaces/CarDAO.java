package ru.agronomych.dao.interfaces;

import ru.agronomych.model.CarModel;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Автомобиль
 */
public interface CarDAO extends CommonDAO<CarModel, String> {

    /**
     * получаем списко автомобилей конкретной модели
     * @param model
     */
    HashMap<CarModel,String> getCarsByModel(String model);

}
