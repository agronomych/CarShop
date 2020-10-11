package dao.implementation;

import dao.interfaces.CarDAO;
import dao.interfaces.ClientDAO;
import dao.interfaces.ContractDAO;
import dao.interfaces.ManagerDAO;
import model.ClientModel;
import model.ContractModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ContractDAOImpl extends CommonDaoImpl<ContractModel,Long> implements ContractDAO {

    public ContractDAOImpl(CarDAO car, ClientDAO client, ManagerDAO manager) {
        super(ContractModel.class, new HashMap<>());
    }

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
