package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.converters.CarDTOConverter;
import ru.agronomych.controller.dto.converters.ClientDTOConverter;
import ru.agronomych.controller.dto.converters.ContractDTOConverter;
import ru.agronomych.controller.dto.converters.ManagerDTOConverter;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.model.Car;
import ru.agronomych.model.Client;
import ru.agronomych.model.Contract;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.fromDTO;
import static ru.agronomych.controller.dto.converters.ClientDTOConverter.toDTO;
import static ru.agronomych.controller.dto.converters.ContractDTOConverter.*;

@Service(value = "ContractService")
public class ContractServiceImpl implements ContractService {

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.contracts}")
    private String filename;

    private ContractDAO contractDAO;
    private ClientService clientService;
    private CarService carService;
    private ManagerService managerService;

    public ContractServiceImpl(ContractDAO contractDAO,
                               ClientService clientService,
                               CarService carService,
                               ManagerService managerService) {
        this.contractDAO = contractDAO;
        this.clientService = clientService;
        this.carService = carService;
        this.managerService = managerService;
    }

    @Override
    public void add(ContractDTO contract) {
        contractDAO.save(
                ContractDTOConverter.fromDTO(contract,
                        CarDTOConverter.fromDTO(carService.getById(contract.getCarId())),
                        ClientDTOConverter.fromDTO(clientService.getById(contract.getClientId())),
                        ManagerDTOConverter.fromDTO(managerService.getById(contract.getManagerId()))));
    }

    @Override
    public void addAll(List<ContractDTO> list) {
        HashMap<Long, Contract> map = new HashMap<>();
        for(ContractDTO contract:list){
            map.put(contract.getId(),
                    ContractDTOConverter.fromDTO(contract,
                        CarDTOConverter.fromDTO(carService.getById(contract.getCarId())),
                        ClientDTOConverter.fromDTO(clientService.getById(contract.getClientId())),
                        ManagerDTOConverter.fromDTO(managerService.getById(contract.getManagerId()))));
        }
        contractDAO.addAll(map);
    }

    @Override
    public List<ContractDTO> getAll() {
        HashMap<Long, Contract> map = (HashMap<Long,Contract>)contractDAO.getAll();
        List<ContractDTO> list = new LinkedList<>();
        for(Contract contract:map.values()){
            list.add(ContractDTOConverter.toDTO(contract,
                    contract.getCar().getId(),
                    contract.getClient().getId(),
                    contract.getManager().getId()));
        }
        return list;
    }

    @Override
    public ContractDTO getById(Long id) {
        Contract contract = contractDAO.getByPK(id);
        return ContractDTOConverter.toDTO(contract,
                contract.getCar().getId(),
                contract.getClient().getId(),
                contract.getManager().getId());
    }

    @Override
    public void deleteById(Long id) {
        contractDAO.deleteByPK(id);
    }

    @Override
    public void update(ContractDTO contract) {
        contractDAO.update(ContractDTOConverter.fromDTO(contract,
                CarDTOConverter.fromDTO(carService.getById(contract.getCarId())),
                ClientDTOConverter.fromDTO(clientService.getById(contract.getClientId())),
                ManagerDTOConverter.fromDTO(managerService.getById(contract.getManagerId()))));
    }

    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Contract contract:contractDAO.getAll().values()){
            list.add(contract.getId());
        }
        return list;
    }

}
