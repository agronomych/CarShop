package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.model.ClientModel;
import ru.agronomych.service.interfaces.ClientService;

import java.util.HashMap;

@Service(value = "ClientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
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
}
