package ru.agronomych.model;

/**
 * Представление сущности Клиент в системе
 */
public class ClientModel extends Human implements Identified<String>{

    /**
     * Ключ, однозначно идентифицирующий авто (номер паспорта)
     */
    private String id;

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
