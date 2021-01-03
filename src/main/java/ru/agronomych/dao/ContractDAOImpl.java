package ru.agronomych.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.agronomych.model.Contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * имплементация интерфейса работы с сущеностью контракт в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ContractDAO")
public class ContractDAOImpl implements ContractDAO {

    private JdbcTemplate jdbcTemplate;

    public ContractDAOImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        simpleJdbcInsert.withTableName("contracts");
    }

    @Override
    public int save(Contract ob) {
        return 0;
    }

    @Override
    public Contract getByPK(Long key) {
        return null;
    }

    @Override
    public int deleteByPK(Long key) {
        return 0;
    }

    @Override
    public int update(Contract ob) {
        return 0;
    }

    @Override
    public List<Contract> getAll() {
        return null;
    }
}
