package dao.interfaces;

import model.CarModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface CarDAO extends CommonDAO<CarModel, String> {

    HashMap<CarModel,String> getCarsByModel(String model);

}
