package ru.agronomych.dao;

import ru.agronomych.model.Car;
import ru.agronomych.model.Identified;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * общий интерфейс для работы со слоем DAO
 */
public interface CommonDAO<T extends Identified<PK>, PK extends Serializable> {

    /**
     * Создает новую запись, соответствующую объекту object
     */
    int save(T ob);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    T getByPK(PK key);

    /**
     * Удаляет запись об объекте по первоичном ключу
     */
    int deleteByPK(PK key);

    /**
     * Сохраняет состояние объекта
     */
    int update(T ob);

    /**
     * Возвращает список объектов соответствующих всем записям
     */
    List<T> getAll();

}
