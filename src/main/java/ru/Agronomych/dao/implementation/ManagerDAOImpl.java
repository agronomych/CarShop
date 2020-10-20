package ru.Agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.Agronomych.dao.interfaces.ManagerDAO;
import ru.Agronomych.model.ManagerModel;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью менеджер в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ManagerDAO")
public class ManagerDAOImpl extends CommonDaoImpl<ManagerModel,Long> implements ManagerDAO {

    public ManagerDAOImpl() {
        super(ManagerModel.class, new HashMap<>());
    }

    /**
     * Получить спиской менеджеров по фамилии
     */
    @Override
    public ManagerModel getManagerByLasName(String lastName) {
        for (ManagerModel el : elements.values()){
            if (el.getLastName().equals(lastName))
                return el;
        }
        return null;
    }

    /**
     * Получить спиской менеджеров по имени
     */
    @Override
    public ManagerModel getManagerByName(String lastName) {
        for (ManagerModel el : elements.values()){
            if (el.getName().equals(lastName))
                return el;
        }
        return null;
    }

    /**
     * Получить спиской менеджеров по отчеству
     */
    @Override
    public ManagerModel getManagerByPatronymic(String patronymic) {
        for (ManagerModel el : elements.values()){
            if (el.getPatronymic().equals(patronymic))
                return el;
        }
        return null;
    }
}
