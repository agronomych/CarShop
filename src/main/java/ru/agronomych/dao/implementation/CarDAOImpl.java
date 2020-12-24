package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.model.CarModel;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью автомобиль в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "CarDAO")
public class CarDAOImpl extends CommonDaoImpl<CarModel,String> implements CarDAO{

    public CarDAOImpl() {
        super(CarModel.class, new HashMap<>());
    }

    /**
     * Получить список автомобилей данной модели
     */
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
