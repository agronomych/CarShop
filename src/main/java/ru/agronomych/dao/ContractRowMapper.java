package ru.agronomych.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.converters.CarDTOConverter;
import ru.agronomych.controller.dto.converters.ClientDTOConverter;
import ru.agronomych.controller.dto.converters.ManagerDTOConverter;
import ru.agronomych.model.Contract;
import ru.agronomych.service.CarService;
import ru.agronomych.service.ClientService;
import ru.agronomych.service.ManagerService;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ContractRowMapper implements RowMapper<Contract> {

    private CarService carService;
    private ClientService clientService;
    private ManagerService managerService;

    /*public ContractRowMapper(CarService carService,
                             ClientService clientService,
                             ManagerService managerService){
        this.carService = carService;
        this.clientService = clientService;
        this.managerService = managerService;
    }*/

    @Override
    public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Contract contract = new Contract();
        contract.setId(Long.parseLong(rs.getString("id")));
        contract.setCar(CarDTOConverter.fromDTO(carService.getById(rs.getString("carId"))));
        contract.setClient(ClientDTOConverter.fromDTO(clientService.getById(Long.parseLong(rs.getString("clientId")))));
        contract.setManager(ManagerDTOConverter.fromDTO(managerService.getById(Long.parseLong(rs.getString("managerId")))));
        contract.setDate(rs.getString("date"));
        contract.setSum(BigDecimal.valueOf(Float.parseFloat(rs.getString("sum"))));
        return contract;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }
}
