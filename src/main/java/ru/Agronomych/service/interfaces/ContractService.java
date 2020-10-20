package ru.Agronomych.service.interfaces;

import ru.Agronomych.model.ContractModel;

import java.util.HashMap;

/**
 * Сервис работоы с контрактом
 *
 * @author Anton_Suryapin
 */
public interface ContractService {

    void addContract(ContractModel contract);

    public  void addAllContracts(HashMap<Long, ContractModel> map);

    public HashMap<Long, ContractModel> getAllContracts();
}
