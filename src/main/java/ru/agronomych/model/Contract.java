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
    private Car car;
    /**
     * клиент покупатель авто
     */
    private Client client;
    /**
     * менеджер, оформивший продажу
     */
    private Manager manager;
    /**
     * дата договора (DD.MM.YYYY)
     */
    private String date;
    /**
     * сумма договора
     */
    private BigDecimal sum;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
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
