package ru.agronomych.controller.dto;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.model.CarModel;
import ru.agronomych.service.interfaces.CarService;

import java.io.Serializable;
import java.util.HashMap;

public class CarDTO implements Serializable {


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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
