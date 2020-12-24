package ru.agronomych.controller.dto;

import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.List;

/**
 * DTO класс для сущности менеджер
 */
public class ManagerDTO implements Serializable {

    /**
     * Ключ, однозначно идентифицирующий менеджера
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
     * поле для возврата ошибок валидации
     */
    private List<ObjectError> errors;

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

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
