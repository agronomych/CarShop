package ru.agronomych.controller.dto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ContractDTO;
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

@Service
@PropertySource(value = {"classpath:application.properties"})
public class ContractDTOService implements DTOService<ContractDTO,ContractModel,Long>{

    @Autowired
    ContractService contractService;
    @Autowired
    ManagerService managerService;
    @Autowired
    CarService carService;
    @Autowired
    ClientService clientService;

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.contracts}")
    private String filename;

    @Override
    public ContractModel fromDTO(ContractDTO contractDTO){
        ContractModel contract = new ContractModel();
        contract.setId(contractDTO.getId());
        contract.setSum(contractDTO.getSum());
        contract.setDate(contractDTO.getDate());
        contract.setCar(carService.getCarById(contractDTO.getCarId()));
        contract.setClient(clientService.getClientById(contractDTO.getClientId()));
        contract.setManager(managerService.getManagerById(contractDTO.getManagerId()));
        return contract;
    }

    @Override
    public ContractDTO toDTO(ContractModel contract){
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCarId(contract.getCar().getId());
        contractDTO.setClientId(contract.getClient().getId());
        contractDTO.setManagerId(contract.getManager().getId());
        contractDTO.setDate(contract.getDate());
        contractDTO.setSum(contract.getSum());
        contractDTO.setId(contract.getId());
        return contractDTO;
    }

    @Override
    public void add(ContractDTO contractData){
        contractService.addContract(fromDTO(contractData));
    }

    @Override
    public ContractDTO get(Long id){
        return toDTO(contractService.getContractById(id));
    }

    @Override
    public HashMap<Long,ContractDTO> getAll(){
        HashMap<Long,ContractDTO> map = new HashMap<>();
        HashMap<Long,ContractModel> mapModels;
        mapModels = contractService.getAllContracts();
        for (ContractModel contract:mapModels.values()){
            map.put(contract.getId(),toDTO(contract));
        }
        return map;
    }

    @Override
    public void delete(Long id){
        contractService.deleteContractById(id);
    }

    @Override
    public void update(ContractDTO contractData){
        contractService.updateContract(fromDTO(contractData));
    }

    @Override
    public String save(){
        try {
            HashMap<Long, ContractDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ContractModel contract:contractService.getAllContracts().values()){
                map.put(contract.getId(),toDTO(contract));
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
                contractService.addContract(fromDTO(contract));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Contracts are loaded correctly";
    }

}
