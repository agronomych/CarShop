package ru.Agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.Agronomych.dao.interfaces.ManagerDAO;
import ru.Agronomych.model.ManagerModel;
import ru.Agronomych.service.interfaces.ManagerService;

import java.util.HashMap;

@Service(value = "ManagerService")
@PropertySource(value = {"classpath:application.properties"})
public class ManagerServiceImpl implements ManagerService {

    @Value("${organization.name}")
    private String orgName;

    private ManagerDAO managerDAO;

    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

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

    @Override
    public String getOrgName() {
        return orgName;
    }
}
