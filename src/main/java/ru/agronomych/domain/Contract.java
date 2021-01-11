package ru.agronomych.domain;

/**
 * Представление сущности Контракт в системе
 */

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "contracts")
public class Contract{

    /**
     * Ключ, однозначно идентифицирующий контракт (id в системе организации)
     */
    @Id
    @Column
    private Long id;

    /**
     * автомобиль, проданный по договору
     */
    @OneToOne()
    @JoinColumn(name = "car_id",
    referencedColumnName = "id")
    private Car car;

    /**
     * клиент, покупатель авто
     */
    @OneToOne()
    @JoinColumn(name = "client_id",
            referencedColumnName = "id")
    private Client client;

    /**
     * менеджер, оформивший продажу
     */
    @OneToOne()
    @JoinColumn(name = "manager_id",
            referencedColumnName = "id")
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

    public void setCar(Car car_join) {
        this.car = car_join;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client_join) {
        this.client = client_join;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager_join) {
        this.manager = manager_join;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCar().getId(), getClient().getId(), getManager().getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contract)) return false;
        Contract contract = (Contract) obj;
        return  Objects.equals(getId(), contract.getId()) &&
                Objects.equals(getCar().getId(), contract.getCar().getId()) &&
                Objects.equals(getClient().getId(),contract.getClient().getId()) &&
                Objects.equals(getManager().getId(), contract.getManager().getId()) &&
                Objects.equals(getDate(),contract.getDate()) &&
                Objects.equals(getSum(),contract.getSum());
    }

    @Override
    public String toString() {
        return getId()+". date: "+getDate()+" :"+getManager().getId()+" "+getClient().getId()+" "+getManager().getId()+" "+getSum();
    }

}
