package ru.agronomych.service.interfaces;

import ru.agronomych.controller.dto.ClientDTO;

import java.util.List;

/**
 * Сервис работоы с клиентом
 *
 * @author Anton_Suryapin
 */
public interface ClientService {

    /**
     * добавляет клиента
     * @param client - клиент, который будет добавлен
     */
    public void add(ClientDTO client);

    /**
     * добавляет список клиентов
     * @param list - список клиентов, которые будут добавлены
     */
    public  void addAll(List<ClientDTO> list);

    /**
     * получить всех клиентов
     * @return - возвращает список клиентов
     */
    public List<ClientDTO> getAll();

    /**
     * получить клиента
     * @param id - уникальный идентификтаор, по которому будет получен клиент
     * @return - полученный клиент
     */
    public ClientDTO getById(Long id);

    /**
     * удаляет клиента
     * @param id - уникальный идентификатор, по которому будет удалён клиент
     */
    public void deleteById(Long id);

    /**
     * обновляет данные клиента
     * @param client - обновлённые данные клиента
     */
    public void update(ClientDTO client);

    /**
     * Получает все уникальные идентификаторы клиентов
     * @return список уникальных идентификаторов клиентов
     */
    public List<Long> getIDs();
}
