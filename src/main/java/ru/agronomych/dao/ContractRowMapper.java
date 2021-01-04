package ru.agronomych.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.agronomych.model.Contract;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractRowMapper implements RowMapper<Contract> {


    @Override
    public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Contract contract = new Contract();
        contract.setId(Long.parseLong(rs.getString("id")));
        contract.setCar(rs.getString("carId"));
        contract.setClient(Long.parseLong(rs.getString("clientId")));
        contract.setManager(Long.parseLong(rs.getString("managerId")));
        contract.setDate(rs.getString("date"));
        contract.setSum(BigDecimal.valueOf(Float.parseFloat(rs.getString("sum"))));
        return contract;
    }

}
