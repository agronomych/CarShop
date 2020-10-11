package dao.implementation;

import dao.interfaces.CarDAO;
import model.CarModel;

import java.util.ArrayList;
import java.util.HashMap;

public class CarDAOImpl extends CommonDaoImpl<CarModel,String> implements CarDAO{

    public CarDAOImpl() {
        super(CarModel.class, new HashMap<>());
    }

    @Override
    public HashMap<CarModel,String> getCarsByModel(String model) {
        HashMap<CarModel,String> temp = new HashMap<CarModel,String>();
        for (CarModel el : elements.values()) {
            if (el.getModel().equals(model)) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }


}
