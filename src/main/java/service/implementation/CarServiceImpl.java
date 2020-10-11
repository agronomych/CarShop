package service.implementation;

import dao.interfaces.CarDAO;
import model.CarModel;
import service.interfaces.CarService;

import java.util.HashMap;

public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    @Override
    public void addCar(CarModel car) {
        carDAO.save(car);
    }

    @Override
    public void addAllCars(HashMap<String, CarModel> map) {
        carDAO.addAll(map);
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public HashMap<String, CarModel> getAllCars() {
        return (HashMap<String, CarModel>) carDAO.getAll();
    }
}
