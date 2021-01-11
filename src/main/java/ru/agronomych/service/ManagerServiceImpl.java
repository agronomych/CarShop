package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.domain.Manager;
import ru.agronomych.repository.ManagerRepository;

import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ManagerDTOConverter.*;

@Service(value = "managerService")
public class ManagerServiceImpl implements ManagerService {

    @Value("${organization.name}")
    private String orgName;

    private ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Transactional
    @Override
    public void add(ManagerDTO manager) {
        managerRepository.save(fromDTO(manager));
    }

    @Transactional
    @Override
    public List<ManagerDTO> getAll() {
        List<Manager> list = managerRepository.findAll();
        List<ManagerDTO> listDTO = new LinkedList<>();
        for(Manager manager:list){
            listDTO.add(toDTO(manager));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ManagerDTO getById(Long id) {
        return toDTO(managerRepository.getOne(id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(ManagerDTO manager) {
        managerRepository.save(fromDTO(manager));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Manager manager:managerRepository.findAll()){
            list.add(manager.getId());
        }
        return list;
    }
}
