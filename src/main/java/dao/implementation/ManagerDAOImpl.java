package dao.implementation;

import dao.interfaces.CarDAO;
import dao.interfaces.ManagerDAO;
import model.CarModel;
import model.ClientModel;
import model.ContractModel;
import model.ManagerModel;

import java.util.HashMap;

public class ManagerDAOImpl extends CommonDaoImpl<ManagerModel,Long> implements ManagerDAO {

    public ManagerDAOImpl() {
        super(ManagerModel.class, new HashMap<>());
    }

    @Override
    public ManagerModel getManagerByLasName(String lastName) {
        for (ManagerModel el : elements.values()){
            if (el.getLastName().equals(lastName))
                return el;
        }
        return null;
    }

    @Override
    public ManagerModel getManagerByName(String lastName) {
        for (ManagerModel el : elements.values()){
            if (el.getName().equals(lastName))
                return el;
        }
        return null;
    }

    @Override
    public ManagerModel getManagerByPatronymic(String patronymic) {
        for (ManagerModel el : elements.values()){
            if (el.getPatronymic().equals(patronymic))
                return el;
        }
        return null;
    }
}
