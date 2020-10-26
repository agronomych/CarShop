package ru.agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.dao.interfaces.ClientDAO;
import ru.agronomych.dao.interfaces.ContractDAO;
import ru.agronomych.dao.interfaces.ManagerDAO;
import ru.agronomych.model.ContractModel;

import java.util.HashMap;

/**
 * имплементация интерфейса работы с сущеностью контракт в слое DAO
 *
 * @author Anton_Suryapin
 */
@Repository(value = "ContractDAO")
public class ContractDAOImpl extends CommonDaoImpl<ContractModel,Long> implements ContractDAO {

    public ContractDAOImpl(CarDAO car, ClientDAO client, ManagerDAO manager) {
        super(ContractModel.class, new HashMap<>());
    }

    @Override
    public HashMap<Long,ContractModel> getContractsByManager(Long managerId) {
        HashMap<Long,ContractModel> temp = new HashMap<Long,ContractModel>();
        for (ContractModel el : elements.values()) {
            if (el.getManager().getId() == managerId) {
                temp.put(managerId,el);
            }
        }
        return temp;
    }
}
