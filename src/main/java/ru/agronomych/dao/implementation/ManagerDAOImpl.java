package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.ManagerDAO;
import ru.agronomych.model.Manager;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью менеджер в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ManagerDAO")
public class ManagerDAOImpl extends CommonDaoImpl<Manager,Long> implements ManagerDAO {

    public ManagerDAOImpl() {
        super(Manager.class, new HashMap<>());
    }

    @Override
    public Manager getManagerByLastName(String lastName) {
        for (Manager el : elements.values()){
            if (el.getLastName().equals(lastName))
                return el;
        }
        return null;
    }

    @Override
    public Manager getManagerByName(String lastName) {
        for (Manager el : elements.values()){
            if (el.getName().equals(lastName))
                return el;
        }
        return null;
    }

    @Override
    public Manager getManagerByPatronymic(String patronymic) {
        for (Manager el : elements.values()){
            if (el.getPatronymic().equals(patronymic))
                return el;
        }
        return null;
    }
}
