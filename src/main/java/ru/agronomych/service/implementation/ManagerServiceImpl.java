package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.dao.interfaces.ManagerDAO;
import ru.agronomych.model.ManagerModel;
import ru.agronomych.service.interfaces.ManagerService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

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
    public void addManager(ManagerModel manager) {
        managerDAO.save(manager);
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

    @Override
    public ManagerModel getManagerById(Long id) {
        return managerDAO.getByPK(id);
    }

    @Override
    public void deleteManagerById(Long id) {
        managerDAO.deleteByPK(id);
    }

    @Override
    public void updateManager(ManagerModel manager) {
        managerDAO.update(manager);
    }

    @Override
    public String save(){
        try {
            HashMap<Long, ManagerDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ManagerModel manager:this.getAllManagers().values()){
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
                this.addManager(fromDTO(manager));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Managers are loaded correctly";
    }
}
