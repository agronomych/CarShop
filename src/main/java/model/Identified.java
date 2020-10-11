package model;

import java.io.Serializable;

public interface Identified<PK extends Serializable> extends Serializable {

        /**
         * Возвращает идентификатор объекта
         */
        PK getId();

}
