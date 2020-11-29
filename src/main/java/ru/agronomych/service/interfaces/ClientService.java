package ru.agronomych.service.interfaces;

import ru.agronomych.model.CarModel;
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
    public  void addAllClients(HashMap<Long, ClientModel> map);

    /**
     * получить всех клиентов
     */
    public HashMap<Long, ClientModel> getAllClients();

    /**
     * получить клиента по id
     */
    public ClientModel getClientById(Long id);

    /**
     * удалить клиента по id
     */
    public void deleteClientById(Long id);

    /**
     * обновить данные клиента по id
     */
    public void updateClient(ClientModel client);

    /**
     * метод сохранения всех данных в файлы
     * @return сообщение об успешном выполнении либо сообщение об ошибке
     */
    public String save();

    /**
     * метод загрузки всех данных из файла
     * @return сообщение об успешном выполнении либо сообщение об ошибке
     */
    public String load();
}
