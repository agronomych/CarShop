package service.implementation;

import dao.interfaces.ClientDAO;
import dao.interfaces.ContractDAO;
import model.ContractModel;
import service.interfaces.ContractService;

import java.util.HashMap;

public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO;

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
