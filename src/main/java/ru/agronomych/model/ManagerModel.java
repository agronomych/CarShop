package ru.agronomych.model;

import java.util.ArrayList;

/**
 * Представление сущности Менеджер в системе
 */
public class ManagerModel extends Human implements Identified<Long>{

    /**
     * идентификатор менеджера в компании
     */
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
