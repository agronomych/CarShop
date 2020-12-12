package ru.agronomych.dao.interfaces;

import ru.agronomych.model.Contract;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Контракт
 */
public interface ContractDAO extends CommonDAO<Contract,Long> {

    /**
     * получить список контрактов конкретного менеджера
     * @param managerId
     */
    HashMap<Long, Contract> getContractsByManager(Long managerId);
}
