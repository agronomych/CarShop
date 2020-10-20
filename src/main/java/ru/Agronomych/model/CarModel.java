package ru.Agronomych.model;

/**
 * Представление сущности Автомобиль в системе
 */
public class CarModel implements Identified<String>{

    private String model;
    private String id;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"Model\":\""+this.getModel()+"\"}";
    }
}
