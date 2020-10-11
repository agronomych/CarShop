package dao.interfaces;

import model.ClientModel;
import model.Human;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientDAO extends CommonDAO<ClientModel,String> {

    HashMap<ClientModel,String> getClientsByLastName(String lastName);

}
