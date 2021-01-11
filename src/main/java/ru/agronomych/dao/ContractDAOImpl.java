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
@Repository(value = "contractDAO")
public class ContractDAOImpl implements ContractDAO {

    private JdbcTemplate jdbcTemplate;

    public ContractDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Contract contract) {
        return jdbcTemplate.update("INSERT INTO contracts VALUES (?, ?, ?, ?, ?, ?)",
                contract.getId(),
                contract.getCar(),
                contract.getClient(),
                contract.getManager(),
                contract.getDate(),
                contract.getSum()
        );
    }

    @Override
    public Contract getByPK(Long key) {
        return jdbcTemplate.queryForObject("SELECT * FROM contracts WHERE id = ?", new Object[]{key}, new ContractRowMapper());
    }

    @Override
    public int deleteByPK(Long key) {
        String sql = "DELETE FROM contracts WHERE id = ?";
        Object[] args = new Object[] {key};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Contract contract) {
        return jdbcTemplate.update("UPDATE contracts SET carId = ?, " +
                        "clientId= ?, managerId = ?, date = ?, sum = ? WHERE id = ?",
                contract.getCar(),
                contract.getClient(),
                contract.getManager(),
                contract.getDate(),
                contract.getSum(),
                contract.getId());
    }

    @Override
    public List<Contract> getAll() {
        return jdbcTemplate.query("SELECT * FROM contracts", new ContractRowMapper());
    }
}
