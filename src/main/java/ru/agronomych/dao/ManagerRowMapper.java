package ru.agronomych.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.agronomych.model.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerRowMapper implements RowMapper<Manager> {

    @Override
    public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Manager manager = new Manager();
        manager.setId(Long.parseLong(rs.getString("id")));
        manager.setLastName(rs.getString("lastName"));
        manager.setName(rs.getString("name"));
        manager.setPatronymic(rs.getString("patronymic"));
        return manager;
    }
}
