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

    @Column(name = "car_id")
    private String car;

    @Column(name = "client_id")
    private Long client;

    @Column(name = "manager_id")
    private Long manager;
//    /**
//     * автомобиль, проданный по договору
//     */
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "car_id",
//    referencedColumnName = "id")
//    private Car car_join;
//
//    /**
//     * клиент, покупатель авто
//     */
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "client_id",
//            referencedColumnName = "id")
//    private Client client_join;
//
//    /**
//     * менеджер, оформивший продажу
//     */
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "manager_id",
//            referencedColumnName = "id")
//    private Manager manager_join;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCar(), getClient(), getManager());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contract)) return false;
        Contract contract = (Contract) obj;
        return  Objects.equals(getId(), contract.getId()) &&
                Objects.equals(getCar(), contract.getCar()) &&
                Objects.equals(getClient(),contract.getClient()) &&
                Objects.equals(getManager(), contract.getManager()) &&
                Objects.equals(getDate(),contract.getDate()) &&
                Objects.equals(getSum(),contract.getSum());
    }

    @Override
    public String toString() {
        return getId()+". date: "+getDate()+" :"+getManager()+" "+getClient()+" "+getManager()+" "+getSum();
    }

}
