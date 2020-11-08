package ru.agronomych.controller.dto;

import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.List;

/**
 * DTO класс для сущности автомобиль
 */
public class CarDTO implements Serializable {

    /**
     * Название модели авто
     */
    private String model;
    /**
     * Ключ, однозначно идентифицирующий авто (VIN)
     */
    private String id;

    /**
     * поле для возврата ошибок валидации
     */
    private List<ObjectError> errors;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
