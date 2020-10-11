package service.interfaces;

import model.CarModel;

import java.util.Collection;
import java.util.HashMap;

public interface CarService {

    public void addCar(CarModel car);

    public  void addAllCars(HashMap<String, CarModel> map);

    public HashMap<String, CarModel> getAllCars();
}
