package dao.implementation;

import dao.interfaces.ClientDAO;
import model.CarModel;
import model.ClientModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientDAOImpl extends CommonDaoImpl<ClientModel, String> implements ClientDAO {

    public ClientDAOImpl() {
        super(ClientModel.class, new HashMap<>());
    }

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
