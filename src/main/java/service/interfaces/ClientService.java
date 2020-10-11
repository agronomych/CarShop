package service.interfaces;

import model.CarModel;
import model.ClientModel;

import java.util.HashMap;

public interface ClientService {

    public void addClient(ClientModel client);

    public  void addAllClients(HashMap<String, ClientModel> map);

    public HashMap<String, ClientModel> getAllClients();
}
