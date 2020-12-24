package ru.agronomych.service;

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
    void add(ManagerDTO manager);

    /**
     * возвращает всех менеджеров
     * @return список всех менеджеров
     */
    List<ManagerDTO> getAll();

    /**
     * получить менеджера
     * @param id - уникальный идентификатор менеджера, которого надо получить
     * @return - полученный менеджер
     */
    ManagerDTO getById(Long id);

    /**
     * удаляет менеджера
      * @param id - уникальный идентификатор менеджера, который будет удалён
     */
    void deleteById(Long id);

    /**
     * Обновляет данные менеджера
     * @param manager - обновлённые данные менеджера
     */
    void update(ManagerDTO manager);

    /**
     * Получает список уникальный идентификаторов менеджеров
     * @return список уникальный идентификаторов менеджеров
     */
    List<Long> getIDs();

}