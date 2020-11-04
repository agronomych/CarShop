package ru.agronomych.model;

import java.util.ArrayList;

/**
 * Представление сущности Менеджер в системе
 */
public class ManagerModel implements Identified<Long> {

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

    /**
     * имя человека
     */
    private String name;
    /**
     * Фамилия человека
     */
    private String lastName;
    /**
     * Отчество человека
     */
    private String patronymic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

}
