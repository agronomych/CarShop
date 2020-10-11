package service.interfaces;

import model.CarModel;
import model.ContractModel;
import model.ManagerModel;

import java.util.HashMap;

public interface ManagerService {

    public void addManager(ManagerModel manager);

    public  void addAllManagers(HashMap<Long, ManagerModel> map);

    public HashMap<Long, ManagerModel> getAllManagers();
}
