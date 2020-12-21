package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.dao.interfaces.ManagerDAO;
import ru.agronomych.model.Manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ManagerDTOConverter.*;

@Service(value = "ManagerService")
@PropertySource(value = {"classpath:application.properties"})
public class ManagerServiceImpl implements ManagerService {

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.managers}")
    private String filename;

    @Value("${organization.name}")
    private String orgName;

    private ManagerDAO managerDAO;

    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public void add(ManagerDTO manager) {
        managerDAO.save(fromDTO(manager));
    }

    @Override
    public List<ManagerDTO> getAll() {
        HashMap<Long,Manager> map = (HashMap<Long, Manager>)managerDAO.getAll();
        List<ManagerDTO> list = new LinkedList<>();
        for(Manager manager:map.values()){
            list.add(toDTO(manager));
        }
        return list;
    }

    @Override
    public ManagerDTO getById(Long id) {
        return toDTO(managerDAO.getByPK(id));
    }

    @Override
    public void deleteById(Long id) {
        managerDAO.deleteByPK(id);
    }

    @Override
    public void update(ManagerDTO manager) {
        managerDAO.update(fromDTO(manager));
    }

    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Manager manager:managerDAO.getAll().values()){
            list.add(manager.getId());
        }
        return list;
    }
}
