package ru.agronomych.dao;

import org.springframework.stereotype.Repository;
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
