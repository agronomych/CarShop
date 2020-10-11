package dao.interfaces;

import model.ContractModel;
import model.ManagerModel;

import java.util.HashMap;

public interface ManagerDAO extends CommonDAO<ManagerModel,Long>{

    public ManagerModel getManagerByLasName(String lastName);

    public ManagerModel getManagerByName(String lastName);

    public ManagerModel getManagerByPatronymic(String patronymic);
}
