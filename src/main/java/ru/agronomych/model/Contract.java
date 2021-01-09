package ru.agronomych.model;

/**
 * Представление сущности Контракт в системе
 */
import java.math.BigDecimal;

public class Contract implements Identified<Long>{

    /**
     * Ключ, однозначно идентифицирующий контракт (id в системе организации)
     */
    private Long id;
    /**
     * Название модели авто, продаваемая по договору
     */
    private String car;
    /**
     * клиент покупатель авто
     */
    private Long client;
    /**
     * менеджер, оформивший продажу
     */
    private Long manager;
    /**
     * дата договора (DD.MM.YYYY)
     */
    private String date;
    /**
     * сумма договора
     */
    private BigDecimal sum;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
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

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
