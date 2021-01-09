package ru.agronomych.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.agronomych.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Car car = new Car();
        car.setId(rs.getString("id"));
        car.setModel(rs.getString("model"));
        return car;
    }
}
