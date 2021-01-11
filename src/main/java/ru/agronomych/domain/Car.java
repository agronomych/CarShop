package ru.agronomych.domain;


import liquibase.pro.packaged.C;

import javax.persistence.*;
import java.util.Objects;

/**
 * Представление сущности Автомобиль в системе
 */
@Entity
@Table(name = "cars")
public class Car {

    /**
     * Ключ, однозначно идентифицирующий авто (VIN)
     */
    @Id
    @Column
    private String id;

    /**
     * Название модели авто
     */
    private String model;

    /**
     * Получить модель машины
     */
    public String getModel() {
        return model;
    }

    /**
     * Установить модель машины
     */
    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @OneToOne(mappedBy = "car_join",cascade = CascadeType.ALL)
//    private Contract contract;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car car = (Car) obj;
        return Objects.equals(getId(), car.getId()) &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public String toString() {
        return getId()+", model:"+getModel();
    }
}
