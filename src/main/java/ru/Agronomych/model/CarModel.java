package ru.Agronomych.model;

/**
 * Представление сущности Автомобиль в системе
 */
public class CarModel implements Identified<String>{

    private String model;
    private String id;

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
        model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
