package ru.agronomych.model;

/**
 * Представление сущности Контракт в системе
 */
import java.math.BigDecimal;

public class ContractModel implements Identified<Long>{

    /**
     * Ключ, однозначно идентифицирующий контракт (id в системе организации)
     */
    private Long id;
    /**
     * Название модели авто, продаваемая по договору
     */
    private CarModel car;
    /**
     * клиент покупатель авто
     */
    private ClientModel client;
    /**
     * менеджер, оформивший продажу
     */
    private ManagerModel manager;
    /**
     * дата договора (DD.MM.YYYY)
     */
    private String date;
    /**
     * сумма договора
     */
    private BigDecimal sum;

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ManagerModel getManager() {
        return manager;
    }

    public void setManager(ManagerModel manager) {
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
