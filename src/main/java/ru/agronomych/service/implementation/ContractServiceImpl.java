package ru.agronomych.service.implementation;

import org.springframework.stereotype.Service;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.model.ContractModel;
import ru.agronomych.service.interfaces.ContractService;

import java.util.HashMap;

@Service(value = "ContractService")
public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO;

    public ContractServiceImpl(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    /**
     * Добавить новый контракт
     */
    @Override
    public void addContract(ContractModel contract) {
        contractDAO.save(contract);
    }

    /**
     * Добавить список контрактов
     */
    @Override
    public void addAllContracts(HashMap<Long, ContractModel> map) {
        contractDAO.addAll(map);
    }

    /**
     * Получить список всех контрактов
     */
    @Override
    public HashMap<Long, ContractModel> getAllContracts() {
        return (HashMap<Long, ContractModel>) contractDAO.getAll();
    }

    @Override
    public HashMap<Long,ContractModel> getAllContractsByManager(Long managerId) {
        return contractDAO.getContractsByManager(managerId);
    }
}
