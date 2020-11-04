package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.model.ContractModel;
import ru.agronomych.service.interfaces.ContractService;

import java.util.HashMap;

@Service(value = "ContractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDAO contractDAO;

    public ContractServiceImpl(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
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
}
