package ru.agronomych.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Представление сущности Клиент в системе
 */
@Entity
@Table(name = "clients")
public class Client {

    /**
     * Ключ, однозначно идентифицирующий клиента
     */
    @Id
    private Long id;

    /**
     * паспорт клиента
     */
    private String passport;

    /**
     * Фамилия клиента
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * имя клиента
     */
    private String name;

    /**
     * Отчество клиента
     */
    private String patronymic;

//    @OneToOne(mappedBy = "client_join", cascade = CascadeType.ALL)
//    private Contract contract;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassport(), getLastName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Client)) return false;
        Client client = (Client) obj;
        return  Objects.equals(getId(), client.getId()) &&
                Objects.equals(getPassport(), client.getPassport()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getPatronymic(), client.getPatronymic());
    }

    @Override
    public String toString() {
        return getId()+", FIO:"+getLastName()+" "+getName()+" "+getPatronymic()+", passport: "+getPassport();
    }
}
