package ru.agronomych.controller.dto;

import java.io.Serializable;

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


}
