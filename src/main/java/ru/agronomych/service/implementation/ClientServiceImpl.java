package ru.agronomych.service.implementation;

import org.springframework.stereotype.Service;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.model.ClientModel;
import ru.agronomych.service.interfaces.ClientService;

import java.util.HashMap;

@Service(value = "ClientService")
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public void addClient(ClientModel client) {
        clientDAO.save(client);
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
    @Override
    public void addAllClients(HashMap<String, ClientModel> map) {
        clientDAO.addAll(map);
    }

    @Override
    public HashMap<String, ClientModel> getAllClients() {
        return (HashMap<String, ClientModel>) clientDAO.getAll();
    }
}
