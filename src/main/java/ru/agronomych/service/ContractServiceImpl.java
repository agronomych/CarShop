package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.converters.CarDTOConverter;
import ru.agronomych.controller.dto.converters.ClientDTOConverter;
import ru.agronomych.controller.dto.converters.ContractDTOConverter;
import ru.agronomych.controller.dto.converters.ManagerDTOConverter;
import ru.agronomych.dao.ContractDAO;
import ru.agronomych.model.Contract;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

    @Transactional
    @Override
    public void add(ContractDTO contract) {
        contractDAO.save(
                ContractDTOConverter.fromDTO(contract,
                        contract.getCarId(),
                        contract.getClientId(),
                        contract.getManagerId()));
    }

    @Transactional
    @Override
    public List<ContractDTO> getAll() {
        List<Contract> list = contractDAO.getAll();
        List<ContractDTO> listDTO = new LinkedList<>();
        for(Contract contract:list){
            listDTO.add(ContractDTOConverter.toDTO(contract,
                    contract.getCar(),
                    contract.getClient(),
                    contract.getManager()));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ContractDTO getById(Long id) {
        Contract contract = contractDAO.getByPK(id);
        return ContractDTOConverter.toDTO(contract,
                contract.getCar(),
                contract.getClient(),
                contract.getManager());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        contractDAO.deleteByPK(id);
    }

    @Transactional
    @Override
    public void update(ContractDTO contract) {
        contractDAO.update(ContractDTOConverter.fromDTO(contract,
                contract.getCarId(),
                contract.getClientId(),
                contract.getManagerId()));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Contract contract:contractDAO.getAll()){
            list.add(contract.getId());
        }
        return list;
    }

}