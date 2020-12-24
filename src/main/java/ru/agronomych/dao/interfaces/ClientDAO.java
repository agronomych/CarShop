package ru.agronomych.dao.interfaces;

import ru.agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * интерфейс для работы со слоем DAO сущности Клиент
 */
public interface ClientDAO extends CommonDAO<ClientModel,String> {

    /**
     * получаем списко клиентов с данной фамилией
     */
    HashMap<ClientModel,String> getClientsByLastName(String lastName);

}
