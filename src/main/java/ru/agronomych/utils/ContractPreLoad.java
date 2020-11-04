package ru.agronomych.utils;

import java.math.BigDecimal;

/**
 * Вспомогательный класс для загрузки тестовых данных -
 * менеджер, автомобиль и клиент указаны с помощью только их id в txt-файлах
 *
 * @author Anton_Suryapin
 */
public class ContractPreLoad {

    /**
     * id контракта в организации
     */
    private Long id;
    /**
     * id автомобиля
     */
    private String carId;
    /**
     * id клиента
     */
    private String clientId;
    /**
     * id менеджера
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
