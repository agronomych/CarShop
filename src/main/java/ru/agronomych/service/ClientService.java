package ru.agronomych.service;

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
    void add(ClientDTO client);

    /**
     * получить всех клиентов
     * @return - возвращает список клиентов
     */
    List<ClientDTO> getAll();

    /**
     * получить клиента
     * @param id - уникальный идентификтаор, по которому будет получен клиент
     * @return - полученный клиент
     */
    ClientDTO getById(Long id);

    /**
     * удаляет клиента
     * @param id - уникальный идентификатор, по которому будет удалён клиент
     */
    void deleteById(Long id);

    /**
     * обновляет данные клиента
     * @param client - обновлённые данные клиента
     */
    void update(ClientDTO client);

    /**
     * Получает все уникальные идентификаторы клиентов
     * @return список уникальных идентификаторов клиентов
     */
    List<Long> getIDs();
}