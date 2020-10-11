package service.implementation;

import dao.interfaces.ContractDAO;
import dao.interfaces.ManagerDAO;
import model.ContractModel;
import model.ManagerModel;
import service.interfaces.ManagerService;

import java.util.HashMap;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDAO managerDAO;

    @Override
    public void addManager(ManagerModel manager) {
        managerDAO.save(manager);
    }

    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public void addAllManagers(HashMap<Long, ManagerModel> map) {
        managerDAO.addAll(map);
    }

    @Override
    public HashMap<Long, ManagerModel> getAllManagers() {
        return (HashMap<Long, ManagerModel>) managerDAO.getAll();
    }
}
