package ru.agronomych.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.agronomych.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * имплементация интерфейса работы с сущеностью автомобиль в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "CarDAO")
public class CarDAOImpl implements CarDAO{

    private JdbcTemplate jdbcTemplate;

    public CarDAOImpl(JdbcTemplate jdbcTemplate,SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        simpleJdbcInsert.withTableName("cars");
    }

    @Override
    public int save(Car car) {
        return jdbcTemplate.update("INSERT INTO cars VALUES (?, ?)", car.getId(),car.getModel() );
    }

    @Override
    public Car getByPK(String key) {
        return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE id = ?", new Object[]{key}, new CarRowMapper());
    }

    @Override
    public int deleteByPK(String key) {
        String sql = "DELETE FROM cars WHERE id = ?";
        Object[] args = new Object[] {key};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Car car) {
        return jdbcTemplate.update("UPDATE cars SET model = ? WHERE id = ?", car.getModel(), car.getId() );
    }

    @Override
    public List<Car> getAll() {
        return jdbcTemplate.query("SELECT * FROM cars", new CarRowMapper());
    }
}
