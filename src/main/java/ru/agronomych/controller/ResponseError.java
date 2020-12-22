package ru.agronomych.controller;

import java.util.UUID;

/**
 * класс для отображения ошибки
 */
public class ResponseError {

    /**
     * id - уникальный номер события
     */
    private UUID id;
    /**
     * code - код ошибки
     */
    private String code;
    /**
     * message - сообщение о ошибке
     */
    private String message;
    /**
     * system - система, в которой произошла ошибка
     */
    private String system;

    public ResponseError(UUID id, String code, String message, String system) {
        this.id = id;
        this.code = code;
        this.message = message;
        this.system = system;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
