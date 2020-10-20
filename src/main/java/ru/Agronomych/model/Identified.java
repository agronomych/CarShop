package ru.Agronomych.model;

import java.io.Serializable;

/**
 * интерфейс идентифицируемых объектов.
 */
public interface Identified<PK extends Serializable> extends Serializable {

        /**
         * Возвращает идентификатор объекта
         */
        PK getId();

}
