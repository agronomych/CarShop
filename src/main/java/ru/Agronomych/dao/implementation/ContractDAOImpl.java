package ru.Agronomych.dao.implementation;

import org.springframework.stereotype.Repository;
import ru.Agronomych.dao.interfaces.CarDAO;
import ru.Agronomych.dao.interfaces.ClientDAO;
import ru.Agronomych.dao.interfaces.ContractDAO;
import ru.Agronomych.dao.interfaces.ManagerDAO;
import ru.Agronomych.model.ContractModel;

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

    /**
     * Получить список контрактов по id менеджера
     */
    @Override
    public HashMap<ContractModel,Long> getContractsByManager(Long managerId) {
        HashMap<ContractModel,Long> temp = new HashMap<ContractModel,Long>();
        for (ContractModel el : elements.values()) {
            if (el.getManager().getId() == managerId) {
                temp.put(el,el.getId());
            }
        }
        return temp;
    }
}
