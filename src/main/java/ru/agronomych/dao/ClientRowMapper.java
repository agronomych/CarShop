package ru.agronomych.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.agronomych.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Client client = new Client();
        client.setPassport(rs.getString("passport"));
        client.setId(Long.parseLong(rs.getString("id")));
        client.setLastName(rs.getString("lastName"));
        client.setName(rs.getString("name"));
        client.setPatronymic(rs.getString("patronymic"));
        return client;
    }
}
