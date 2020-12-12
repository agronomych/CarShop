package ru.agronomych.dao.interfaces;

import ru.agronomych.model.Manager;

/**
 * интерфейс для работы со слоем DAO сущности Менеджер
 */
public interface ManagerDAO extends CommonDAO<Manager,Long>{

    /**
     * получить список менеджеров по имени
     * @param lastName
     */
    public Manager getManagerByLastName(String lastName);

    /**
     * получить список менеджеров по фамилии
     * @param lastName
     */
    public Manager getManagerByName(String lastName);

    /**
     * получить список менеджеров по отчеству
     * @param patronymic
     */
    public Manager getManagerByPatronymic(String patronymic);
}
