package ru.agronomych.dao.interfaces;

import ru.agronomych.model.ManagerModel;

/**
 * интерфейс для работы со слоем DAO сущности Менеджер
 */
public interface ManagerDAO extends CommonDAO<ManagerModel,Long>{

    /**
     * получить список менеджеров по имени
     * @param lastName
     */
    public ManagerModel getManagerByLastName(String lastName);

    /**
     * получить список менеджеров по фамилии
     * @param lastName
     */
    public ManagerModel getManagerByName(String lastName);

    /**
     * получить список менеджеров по отчеству
     * @param patronymic
     */
    public ManagerModel getManagerByPatronymic(String patronymic);
}
