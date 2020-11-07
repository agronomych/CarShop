package ru.agronomych.controller.dto;

import java.io.Serializable;

/**
 * DTO класс для сущности клиент
 */
public class ClientDTO implements Serializable {


    /**
     * Ключ, однозначно идентифицирующий клиента
     */
    private Long id;
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

    /**
     * пасспорт человека
     */
    private String passport;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
