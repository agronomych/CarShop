package service.implementation;

import dao.interfaces.CarDAO;
import dao.interfaces.ClientDAO;
import model.CarModel;
import model.ClientModel;
import service.interfaces.ClientService;

import java.util.HashMap;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

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
