package ru.agronomych.dao.interfaces;

import ru.agronomych.model.Client;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Клиент
 */
public interface ClientDAO extends CommonDAO<Client,Long> {

    /**
     * получаем списко клиентов с данной фамилией
     * @param lastName
     */
    HashMap<Client,Long> getClientsByLastName(String lastName);

}
