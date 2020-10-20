package ru.Agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.Agronomych.dao.interfaces.ClientDAO;
import ru.Agronomych.model.ClientModel;
import ru.Agronomych.service.interfaces.ClientService;

import java.util.HashMap;

@Service(value = "ClientService")
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    /**
     * Добаивть нового клиента
     */
    @Override
    public void addClient(ClientModel client) {
        clientDAO.save(client);
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
