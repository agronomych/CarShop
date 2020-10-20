package ru.Agronomych.dao.interfaces;

import ru.Agronomych.model.CarModel;

import java.util.HashMap;

public interface CarDAO extends CommonDAO<CarModel, String> {

    HashMap<CarModel,String> getCarsByModel(String model);

}
