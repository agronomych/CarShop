package ru.Agronomych.dao.interfaces;

import ru.Agronomych.model.ClientModel;

import java.util.HashMap;

public interface ClientDAO extends CommonDAO<ClientModel,String> {

    HashMap<ClientModel,String> getClientsByLastName(String lastName);

}
