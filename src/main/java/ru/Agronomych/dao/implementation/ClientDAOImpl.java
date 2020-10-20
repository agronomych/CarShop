package ru.Agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.Agronomych.dao.interfaces.ClientDAO;
import ru.Agronomych.model.ClientModel;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью клиент в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ClientDAO")
public class ClientDAOImpl extends CommonDaoImpl<ClientModel, String> implements ClientDAO {

    public ClientDAOImpl() {
        super(ClientModel.class, new HashMap<>());
    }

    /**
     * Получить список клиентов с данной фамилией
     */
    @Override
    public HashMap<ClientModel,String> getClientsByLastName(String lastName) {
        HashMap<ClientModel,String> temp = new HashMap<ClientModel,String>();
        for (ClientModel el : elements.values()) {
            if (el.getLastName().equals(lastName)) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }

}
