package ru.agronomych.dao;

import org.springframework.stereotype.Repository;
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

}
