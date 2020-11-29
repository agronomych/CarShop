package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.model.ClientModel;
import ru.agronomych.service.interfaces.ClientService;
import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@Service(value = "ClientService")
@PropertySource(value = {"classpath:application.properties"})
public class ClientServiceImpl implements ClientService {

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.clients}")
    private String filename;

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public void addClient(ClientModel client) {
        clientDAO.save(client);
    }

    @Override
    public void addAllClients(HashMap<Long, ClientModel> map) {
        clientDAO.addAll(map);
    }

    @Override
    public HashMap<Long, ClientModel> getAllClients() {
        return (HashMap<Long, ClientModel>) clientDAO.getAll();
    }

    @Override
    public ClientModel getClientById(Long id) {
        return clientDAO.getByPK(id);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDAO.deleteByPK(id);
    }

    @Override
    public void updateClient(ClientModel client) {
        clientDAO.update(client);
    }

    @Override
    public String save(){
        try {
            HashMap<Long, ClientDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ClientModel client:this.getAllClients().values()){
                map.put(client.getId(),toDTO(client));
            }
            output.writeObject(map);
            output.close();
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Clients are saved correctly";
    }

    @Override
    public String load(){
        try {
            HashMap<Long,ClientDTO> map;
            FileInputStream inputStream = new FileInputStream(dbPath+"/"+filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            map  = (HashMap<Long,ClientDTO>)input.readObject();
            for(ClientDTO client:map.values()){
                this.addClient(fromDTO(client));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Clients are loaded correctly";
    }
}
