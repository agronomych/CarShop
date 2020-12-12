package ru.agronomych.service.interfaces;

import ru.agronomych.controller.dto.ManagerDTO;

import java.util.List;

/**
 * Сервис работоы с менеджером
 *
 * @author Anton_Suryapin
 */
public interface ManagerService {

    /**
     * добавляет менеджера
     * @param manager - данные менеджера, который будет добавлен
     */
    public void add(ManagerDTO manager);

    /**
     * добавляет список менеджеров
     * @param list - список добавляемых менеджеров
     */
    public  void addAll(List<ManagerDTO> list);

    /**
     * возвращает всех менеджеров
     * @return список всех менеджеров
     */
    public List<ManagerDTO> getAll();

    /**
     * получить имя оранизации
     */
    public String getOrgName();

    /**
     * получить менеджера
     * @param id - уникальный идентификатор менеджера, которого надо получить
     * @return - полученный менеджер
     */
    public ManagerDTO getById(Long id);

    /**
     * удаляет менеджера
      * @param id - уникальный идентификатор менеджера, который будет удалён
     */
    public void deleteById(Long id);

    /**
     * Обновляет данные менеджера
     * @param manager - обновлённые данные менеджера
     */
    public void update(ManagerDTO manager);

    /**
     * Получает список уникальный идентификаторов менеджеров
     * @return список уникальный идентификаторов менеджеров
     */
    public List<Long> getIDs();

}
