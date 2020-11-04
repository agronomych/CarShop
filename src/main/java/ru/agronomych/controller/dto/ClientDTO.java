package ru.agronomych.controller.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {


    /**
     * Ключ, однозначно идентифицирующий авто (номер паспорта)
     */
    private String id;
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
