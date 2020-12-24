package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.model.Client;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

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
    public void add(ClientDTO client) {
        clientDAO.save(fromDTO(client));
    }

    @Override
    public List<ClientDTO> getAll() {
        HashMap<Long,Client> map = (HashMap<Long, Client>)clientDAO.getAll();
        List<ClientDTO> list = new LinkedList<>();
        for(Client client:map.values()){
            list.add(toDTO(client));
        }
        return list;
    }

    @Override
    public ClientDTO getById(Long id) {
        return toDTO(clientDAO.getByPK(id));
    }

    @Override
    public void deleteById(Long id) {
        clientDAO.deleteByPK(id);
    }

    @Override
    public void update(ClientDTO client) {
        clientDAO.update(fromDTO(client));
    }

    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Client client:clientDAO.getAll().values()){
            list.add(client.getId());
        }
        return list;
    }
}
