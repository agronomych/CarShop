package ru.agronomych.service.interfaces;

import ru.agronomych.model.ClientModel;
import ru.agronomych.model.ManagerModel;

import java.util.HashMap;

/**
 * Сервис работоы с менеджером
 *
 * @author Anton_Suryapin
 */
public interface ManagerService {

    /**
     * добавить менеджера
     */
    public void addManager(ManagerModel manager);

    /**
     * добавить группу менеджеров
     */
    public  void addAllManagers(HashMap<Long, ManagerModel> map);

    /**
     * получить всех менеджеров
     */
    public HashMap<Long, ManagerModel> getAllManagers();

    /**
     * получить имя оранизации
     */
    public String getOrgName();

    /**
     * получить менеджера по id
     */
    public ManagerModel getManagerById(Long id);

    /**
     * удалить менеджера по id
     */
    public void deleteManagerById(Long id);

    /**
     * обновить данные менеджера по id
     */
    public void updateManager(ManagerModel manager);

}
