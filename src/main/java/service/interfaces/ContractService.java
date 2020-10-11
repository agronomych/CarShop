package service.interfaces;

import model.CarModel;
import model.ContractModel;

import java.util.HashMap;

public interface ContractService {

    void addContract(ContractModel contract);

    public  void addAllContracts(HashMap<Long, ContractModel> map);

    public HashMap<Long, ContractModel> getAllContracts();
}
