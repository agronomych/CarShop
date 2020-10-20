package ru.Agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.Agronomych.dao.interfaces.ContractDAO;
import ru.Agronomych.model.ContractModel;
import ru.Agronomych.service.interfaces.ContractService;

import java.util.HashMap;

@Service(value = "ContractService")
public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO;

    public ContractServiceImpl(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Override
    public void addContract(ContractModel contract) {
        contractDAO.save(contract);
    }

    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Override
    public void addAllContracts(HashMap<Long, ContractModel> map) {
        contractDAO.addAll(map);
    }

    @Override
    public HashMap<Long, ContractModel> getAllContracts() {
        return (HashMap<Long, ContractModel>) contractDAO.getAll();
    }
}
