package ru.agronomych.controller.dto;

import ru.agronomych.model.CarModel;
import ru.agronomych.model.ClientModel;
import ru.agronomych.model.ManagerModel;

import java.io.Serializable;
import java.math.BigDecimal;

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
    private String clientId;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
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
}
