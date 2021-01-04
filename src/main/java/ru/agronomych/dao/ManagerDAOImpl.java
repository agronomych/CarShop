package ru.agronomych.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.agronomych.model.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * имплементация интерфейса работы с сущеностью менеджер в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ManagerDAO")
public class ManagerDAOImpl implements ManagerDAO {

    private JdbcTemplate jdbcTemplate;

    public ManagerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Manager manager) {
        return jdbcTemplate.update("INSERT INTO managers VALUES (?, ?, ?, ?)",
                manager.getId(),
                manager.getName(),
                manager.getLastName(),
                manager.getPatronymic());
    }

    @Override
    public Manager getByPK(Long key) {
        return jdbcTemplate.queryForObject("SELECT * FROM managers WHERE id = ?", new Object[]{key}, new ManagerRowMapper());
    }

    @Override
    public int deleteByPK(Long key) {
        String sql = "DELETE FROM managers WHERE id = ?";
        Object[] args = new Object[] {key};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Manager manager) {
        return jdbcTemplate.update("UPDATE managers SET name = ?, " +
                        "lastName = ?, patronymic = ? WHERE id = ?",
                manager.getName(),
                manager.getLastName(),
                manager.getPatronymic(),
                manager.getId());
    }

    @Override
    public List<Manager> getAll() {
        return jdbcTemplate.query("SELECT * FROM managers", new ManagerRowMapper());
    }
}
