package ru.Agronomych.dao.interfaces;

import ru.Agronomych.model.ManagerModel;

public interface ManagerDAO extends CommonDAO<ManagerModel,Long>{

    public ManagerModel getManagerByLasName(String lastName);

    public ManagerModel getManagerByName(String lastName);

    public ManagerModel getManagerByPatronymic(String patronymic);
}
