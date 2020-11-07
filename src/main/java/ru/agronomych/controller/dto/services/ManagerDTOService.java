package ru.agronomych.controller.dto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.model.ManagerModel;
import ru.agronomych.service.interfaces.ManagerService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * сервис для работы со слоем DTO сущности Менеджер
 */

@Service
@PropertySource(value = {"classpath:application.properties"})
public class ManagerDTOService implements DTOService<ManagerDTO,ManagerModel,Long>{
    
    @Autowired
    ManagerService managerService;

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.managers}")
    private String filename;

    @Override
    public ManagerModel fromDTO(ManagerDTO managerDTO){
        ManagerModel manager = new ManagerModel();
        manager.setId((managerDTO.getId()));
        manager.setLastName(managerDTO.getLastName());
        manager.setName(managerDTO.getName());
        manager.setPatronymic(managerDTO.getPatronymic());
        return manager;
    }

    @Override
    public ManagerDTO toDTO(ManagerModel manager){
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setLastName(manager.getLastName());
        managerDTO.setName(manager.getName());
        managerDTO.setPatronymic(manager.getPatronymic());
        return managerDTO;
    }

    @Override
    public void add(ManagerDTO managerData){
        managerService.addManager(fromDTO(managerData));
    }

    @Override
    public ManagerDTO get(Long id){
        return toDTO(managerService.getManagerById(id));
    }

    @Override
    public HashMap<Long,ManagerDTO> getAll(){
        HashMap<Long,ManagerDTO> map = new HashMap<>();
        HashMap<Long,ManagerModel> mapModels;
        mapModels = managerService.getAllManagers();
        for (ManagerModel manager:mapModels.values()) {
            map.put(manager.getId(),toDTO(manager));
        }
        return map;
    }

    @Override
    public void delete(Long id){
        managerService.deleteManagerById(id);
    }

    @Override
    public void update(ManagerDTO managerData){
        managerService.updateManager(fromDTO(managerData));
    }

    @Override
    public String save(){
        try {
            HashMap<Long, ManagerDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ManagerModel manager:managerService.getAllManagers().values()){
                map.put(manager.getId(),toDTO(manager));
            }
            output.writeObject(map);
            output.close();
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Managers are saved correctly";
    }

    @Override
    public String load(){
        try {
            HashMap<Long,ManagerDTO> map;
            FileInputStream inputStream = new FileInputStream(dbPath+"/"+filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            map  = (HashMap<Long,ManagerDTO>)input.readObject();
            for(ManagerDTO manager:map.values()){
                managerService.addManager(fromDTO(manager));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Managers are loaded correctly";
    }
}
