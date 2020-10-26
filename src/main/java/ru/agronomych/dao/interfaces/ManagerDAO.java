package ru.agronomych.dao.interfaces;

import ru.agronomych.model.ManagerModel;

/**
 * интерфейс для работы со слоем DAO сущности Менеджер
 */
public interface ManagerDAO extends CommonDAO<ManagerModel,Long>{

    /**
     * получить список менеджеров по имени
     */
    public ManagerModel getManagerByLastName(String lastName);

    /**
     * получить список менеджеров по фамилии
     */
    public ManagerModel getManagerByName(String lastName);

    /**
     * получить список менеджеров по отчеству
     */
    public ManagerModel getManagerByPatronymic(String patronymic);
}
