package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.dao.ManagerDAO;
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

    @Transactional
    @Override
    public void add(ManagerDTO manager) {
        managerDAO.save(fromDTO(manager));
    }

    @Transactional
    @Override
    public List<ManagerDTO> getAll() {
        List<Manager> list = managerDAO.getAll();
        List<ManagerDTO> listDTO = new LinkedList<>();
        for(Manager manager:list){
            listDTO.add(toDTO(manager));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ManagerDTO getById(Long id) {
        return toDTO(managerDAO.getByPK(id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        managerDAO.deleteByPK(id);
    }

    @Transactional
    @Override
    public void update(ManagerDTO manager) {
        managerDAO.update(fromDTO(manager));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Manager manager:managerDAO.getAll()){
            list.add(manager.getId());
        }
        return list;
    }
}
