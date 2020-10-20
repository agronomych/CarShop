package ru.Agronomych.service.interfaces;

import ru.Agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * Сервис работоы с клиентом
 *
 * @author Anton_Suryapin
 */
public interface ClientService {

    public void addClient(ClientModel client);

    public  void addAllClients(HashMap<String, ClientModel> map);

    public HashMap<String, ClientModel> getAllClients();
}
