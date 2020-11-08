package ru.agronomych.controller.dto;

import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO класс для сущности контракт
 */
public class ContractDTO implements Serializable {

    /**
     * Ключ, однозначно идентифицирующий контракт (id в системе организации)
     */
    private Long id;
    /**
     * Название модели авто, продаваемая по договору
     */
    private String carId;
    /**
     * клиент покупатель авто
     */
    private Long clientId;
    /**
     * менеджер, оформивший продажу
     */
    private Long managerId;
    /**
     * дата договора (DD.MM.YYYY)
     */
    private String date;
    /**
     * сумма договора
     */
    private BigDecimal sum;

    /**
     * поле для возврата ошибок валидации
     */
    private List<ObjectError> errors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
