package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.dao.interfaces.ManagerDAO;
import ru.agronomych.model.Contract;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью контракт в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ContractDAO")
public class ContractDAOImpl extends CommonDaoImpl<Contract,Long> implements ContractDAO {

    public ContractDAOImpl(CarDAO car, ClientDAO client, ManagerDAO manager) {
        super(Contract.class, new HashMap<>());
    }

}
