package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.ClientDAO;
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

    /**
     * Получаем список клиентов с указанной фамилией
     * @param lastName
     * @return
     */
    @Override
    public HashMap<Client,Long> getClientsByLastName(String lastName) {
        HashMap<Client,Long> temp = new HashMap();
        for (Client el : elements.values()) {
            if (el.getLastName().equals(lastName)) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }

}
