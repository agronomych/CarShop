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

    public ManagerDAOImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        simpleJdbcInsert.withTableName("managers");
    }

    @Override
    public int save(Manager ob) {
        return 0;
    }

    @Override
    public Manager getByPK(Long key) {
        return null;
    }

    @Override
    public int deleteByPK(Long key) {
        return 0;
    }

    @Override
    public int update(Manager ob) {
        return 0;
    }

    @Override
    public List<Manager> getAll() {
        return null;
    }
}
