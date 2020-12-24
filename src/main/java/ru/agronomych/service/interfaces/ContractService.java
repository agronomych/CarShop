package ru.agronomych.service.interfaces;

import ru.agronomych.model.ContractModel;

import java.util.HashMap;

/**
 * Сервис работоы с контрактом
 *
 * @author Anton_Suryapin
 */
public interface ContractService {

    /**
     * добавить контракт
     */
    void addContract(ContractModel contract);

    /**
     * добавить группу контрактов
     */
    public  void addAllContracts(HashMap<Long, ContractModel> map);

    /**
     * получить все контракты
     */
    public HashMap<Long, ContractModel> getAllContracts();

    /**
     * получить все контракты по id менеджера
     */
    public HashMap<Long,ContractModel> getAllContractsByManager(Long managerId);
}
