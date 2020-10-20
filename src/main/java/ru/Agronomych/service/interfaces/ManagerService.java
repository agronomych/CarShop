package ru.Agronomych.service.interfaces;

import ru.Agronomych.model.ManagerModel;

import java.util.HashMap;

/**
 * Сервис работоы с менеджером
 *
 * @author Anton_Suryapin
 */
public interface ManagerService {

    public void addManager(ManagerModel manager);

    public  void addAllManagers(HashMap<Long, ManagerModel> map);

    public HashMap<Long, ManagerModel> getAllManagers();

    public String getOrgName();
}
