package ru.Agronomych.model;

/**
 * Представление сущности Клиент в системе
 */
public class ClientModel extends Human implements Identified<String>{

    private String id;

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getLastName()+" "+this.getName()+" "+ this.getPatronymic();
    }
}
