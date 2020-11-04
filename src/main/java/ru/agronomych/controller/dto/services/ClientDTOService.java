package ru.agronomych.controller.dto.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.model.ClientModel;
import ru.agronomych.service.interfaces.ClientService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class ClientDTOService implements DTOService<ClientDTO,ClientModel,String>{

    @Autowired
    ClientService clientService;

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.clients}")
    private String filename;

    @Override
    public ClientModel fromDTO(ClientDTO clientDTO){
        ClientModel client = new ClientModel();
        client.setId((clientDTO.getId()));
        client.setLastName(clientDTO.getLastName());
        client.setName(clientDTO.getName());
        client.setPatronymic(clientDTO.getPatronymic());
        return client;
    }

    @Override
    public ClientDTO toDTO(ClientModel client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setName(client.getName());
        clientDTO.setPatronymic(client.getPatronymic());
        return clientDTO;
    }

    @Override
    public void add(ClientDTO clientData){
        clientService.addClient(fromDTO(clientData));
    }

    @Override
    public ClientDTO get(String id){
        return toDTO(clientService.getClientById(id));
    }

    @Override
    public HashMap<String,ClientDTO> getAll(){
        HashMap<String,ClientDTO> map = new HashMap<>();
        HashMap<String,ClientModel> mapModels;
        mapModels = clientService.getAllClients();
        for (ClientModel client:mapModels.values()) {
            map.put(client.getId(),toDTO(client));
        }
        return map;
    }

    @Override
    public void delete(String id){
        clientService.deleteClientById(id);
    }
    
    @Override
    public void update(ClientDTO clientData){
        clientService.updateClient(fromDTO(clientData));
    }

    @Override
    public String save(){
        try {
            HashMap<String, ClientDTO> map = new HashMap<>();
            FileOutputStream outputStream = new FileOutputStream(dbPath+"/"+filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            for(ClientModel client:clientService.getAllClients().values()){
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
            HashMap<String,ClientDTO> map = new HashMap<>();
            FileInputStream inputStream = new FileInputStream(dbPath+"/"+filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            map  = (HashMap<String,ClientDTO>)input.readObject();
            for(ClientDTO client:map.values()){
                clientService.addClient(fromDTO(client));
            }
        }
        catch (Exception e){
            return "Something is wrong with I/O";
        }
        return "Clients are loaded correctly";
    }
}
