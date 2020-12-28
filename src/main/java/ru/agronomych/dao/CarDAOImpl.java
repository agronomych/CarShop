package ru.agronomych.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.agronomych.model.Car;
import ru.agronomych.model.Client;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью автомобиль в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "CarDAO")
public class CarDAOImpl extends CommonDaoImpl<Car,String> implements CarDAO{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public CarDAOImpl(JdbcTemplate jdbcTemplate,SimpleJdbcInsert simpleJdbcInsert) {
        super(Car.class, new HashMap<>());
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("car");
    }


}
