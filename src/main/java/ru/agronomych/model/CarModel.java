package ru.agronomych.model;

/**
 * Представление сущности Автомобиль в системе
 */
public class CarModel implements Identified<String>{

    /**
     * Название модели авто
     */
    private String model;
    /**
     * Ключ, однозначно идентифицирующий авто (VIN)
     */
    private String id;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
