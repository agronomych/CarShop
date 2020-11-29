package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.model.ContractModel;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

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
    public void addContract(ContractModel contract) {
        contractDAO.save(contract);
    }

    @Override
    public void addAllContracts(HashMap<Long, ContractModel> map) {
        contractDAO.addAll(map);
    }

    @Override
    public HashMap<Long, ContractModel> getAllContracts() {
        return (HashMap<Long, ContractModel>) contractDAO.getAll();
    }

    @Override
    public ContractModel getContractById(Long id) {
        return contractDAO.getByPK(id);
    }

    @Override
    public void deleteContractById(Long id) {
        contractDAO.deleteByPK(id);
    }

    @Override
    public void updateContract(ContractModel contract) {
        contractDAO.update(contract);
    }

    @Override
    public String save(){
        try {
            HashMap<Long, ContractDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ContractModel contract:this.getAllContracts().values()){
                map.put(contract.getId(),
                        toDTO(  contract,
                                contract.getCar().getId(),
                                contract.getClient().getId(),
                                contract.getManager().getId()));
            }
            output.writeObject(map);
            output.close();
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Contracts are saved correctly";
    }

    @Override
    public String load(){
        try {
            HashMap<Long,ContractDTO> map;
            FileInputStream inputStream = new FileInputStream(dbPath+"/"+filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            map  = (HashMap<Long, ContractDTO>)input.readObject();
            for(ContractDTO contract:map.values()){
                this.addContract(
                        fromDTO(contract,
                                carService.getCarById(contract.getCarId()),
                                clientService.getClientById(contract.getClientId()),
                                managerService.getManagerById(contract.getManagerId())));

            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Contracts are loaded correctly";
    }
}
