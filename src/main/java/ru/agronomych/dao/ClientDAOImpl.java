package ru.agronomych.dao;

import org.springframework.stereotype.Repository;
import ru.agronomych.model.Client;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущностью клиент в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ClientDAO")
public class ClientDAOImpl extends CommonDaoImpl<Client, Long> implements ClientDAO {

    public ClientDAOImpl() {
        super(Client.class, new HashMap<>());
    }

}
