package ru.agronomych.service.interfaces;

import ru.agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * Сервис работоы с клиентом
 *
 * @author Anton_Suryapin
 */
public interface ClientService {

    /**
     * добавить клиента
     */
    public void addClient(ClientModel client);

    /**
     * добавить группу клиентов
     */
    public  void addAllClients(HashMap<String, ClientModel> map);

    /**
     * получить всех клиентов
     */
    public HashMap<String, ClientModel> getAllClients();
}
