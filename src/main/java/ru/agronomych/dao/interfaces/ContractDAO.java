package ru.agronomych.dao.interfaces;

import ru.agronomych.model.ContractModel;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Контракт
 */
public interface ContractDAO extends CommonDAO<ContractModel,Long> {

    /**
     * получить список контрактов конкретного менеджера
     */
    HashMap<Long,ContractModel> getContractsByManager(Long managerId);
}
