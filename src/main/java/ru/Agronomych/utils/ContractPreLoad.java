package ru.Agronomych.utils;

import java.math.BigDecimal;

/**
 * Вспомогательный класс для загрузки тестовых данных -
 * менеджер, автомобиль и клиент указаны с помощью только их id в txt-файлах
 *
 * @author Anton_Suryapin
 */
public class ContractPreLoad {

    private Long id;
    private String car;
    private String client;
    private Long manager;
    private String date;
    private BigDecimal sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
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
