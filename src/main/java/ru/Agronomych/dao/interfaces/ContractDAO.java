package ru.Agronomych.dao.interfaces;

import ru.Agronomych.model.ContractModel;

import java.util.HashMap;

public interface ContractDAO extends CommonDAO<ContractModel,Long> {

    HashMap<ContractModel,Long> getContractsByManager(Long managerId);
}
