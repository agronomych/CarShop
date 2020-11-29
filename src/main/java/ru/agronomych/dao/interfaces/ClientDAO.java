package ru.agronomych.dao.interfaces;

import ru.agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Клиент
 */
public interface ClientDAO extends CommonDAO<ClientModel,Long> {

    /**
     * получаем списко клиентов с данной фамилией
     * @param lastName
     */
    HashMap<ClientModel,Long> getClientsByLastName(String lastName);

}
