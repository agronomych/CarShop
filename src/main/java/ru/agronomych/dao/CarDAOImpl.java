package ru.agronomych.dao;

import org.springframework.stereotype.Repository;
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

}
