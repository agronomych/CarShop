package ru.Agronomych.dao.interfaces;

import ru.Agronomych.model.Identified;

import java.io.Serializable;
import java.util.Map;

public interface CommonDAO<T extends Identified<PK>, PK extends Serializable> {

    /**
     * Создает новую запись, соответствующую объекту object
     */
    T save(T ob);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    T getByPK(PK key);

    /**
     * Удаляет запись об объекте по первоичном ключу
     */
    T deleteByPK(PK key);

    /**
     * Сохраняет состояние объекта
     */
    T update(T ob);

    /**
     * Удаляет запись об объекте
     */
    T delete(T ob);

    /**
     * Возвращает список объектов соответствующих всем записям
     */
    Map<PK,T> getAll();

    /**
     * Создает новые записи, соответствующему списку объектов object
     */
    void addAll(Map<PK,T> all);

}
