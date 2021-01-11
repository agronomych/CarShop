package ru.agronomych.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Представление сущности Менеджер в системе
 */
@Entity
@Table(name = "managers")
public class Manager{

    /**
     * Ключ, однозначно идентифицирующий менеджера
     */
    @Id
    @Column
    private Long id;

    /**
     * Фамилия менеджера
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * имя менеджера
     */
    private String name;

    /**
     * Отчество менеджера
     */
    private String patronymic;

    @OneToOne(mappedBy = "manager")
    private Contract contract;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return Objects.hash(getId(), getLastName(), getPatronymic());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        Manager manager = (Manager) obj;
        return  Objects.equals(getId(), manager.getId()) &&
                Objects.equals(getLastName(), manager.getLastName()) &&
                Objects.equals(getName(), manager.getName()) &&
                Objects.equals(getPatronymic(), manager.getPatronymic());
    }

    @Override
    public String toString() {
        return getId()+", FIO:"+getLastName()+" "+getName()+" "+getPatronymic();
    }
}
