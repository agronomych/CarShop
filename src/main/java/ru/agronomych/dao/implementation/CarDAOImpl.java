package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.model.Car;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью автомобиль в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "CarDAO")
public class CarDAOImpl extends CommonDaoImpl<Car,String> implements CarDAO{

    public CarDAOImpl() {
        super(Car.class, new HashMap<>());
    }

    /**
     * Получаем список автомобилей указанной модели
     * @param model
     * @return
     */
    @Override
    public HashMap<Car,String> getCarsByModel(String model) {
        HashMap<Car,String> temp = new HashMap<Car,String>();
        for (Car el : elements.values()) {
            if (el.getModel().equals(model)) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }


}
