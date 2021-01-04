package ru.agronomych.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.agronomych.model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * имплементация интерфейса работы с сущностью клиент в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ClientDAO")
public class ClientDAOImpl implements ClientDAO {

    private JdbcTemplate jdbcTemplate;

    public ClientDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Client client) {
        return jdbcTemplate.update("INSERT INTO clients VALUES (?, ?, ?, ?, ?)",
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getPatronymic(),
                client.getPassport());
    }

    @Override
    public Client getByPK(Long key) {
        return jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id = ?", new Object[]{key}, new ClientRowMapper());
    }

    @Override
    public int deleteByPK(Long key) {
        String sql = "DELETE FROM clients WHERE id = ?";
        Object[] args = new Object[] {key};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Client client) {
        return jdbcTemplate.update("UPDATE clients SET name = ?, " +
                "lastName = ?, patronymic = ?, passport = ? WHERE id = ?",
                client.getName(),
                client.getLastName(),
                client.getPatronymic(),
                client.getPassport(),
                client.getId());
    }

    @Override
    public List<Client> getAll() {
        return jdbcTemplate.query("SELECT * FROM clients", new ClientRowMapper());
    }
}
