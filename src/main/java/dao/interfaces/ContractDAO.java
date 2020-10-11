package dao.interfaces;

import model.ContractModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface ContractDAO extends CommonDAO<ContractModel,Long> {

    HashMap<ContractModel,Long> getContractsByManager(Long managerId);
}
