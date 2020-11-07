package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущностью клиент в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ClientDAO")
public class ClientDAOImpl extends CommonDaoImpl<ClientModel, Long> implements ClientDAO {

    public ClientDAOImpl() {
        super(ClientModel.class, new HashMap<>());
    }

    @Override
    public HashMap<ClientModel,Long> getClientsByLastName(String lastName) {
        HashMap<ClientModel,Long> temp = new HashMap();
        for (ClientModel el : elements.values()) {
            if (el.getLastName().equals(lastName)) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }

}
