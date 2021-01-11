package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.domain.Car;

/**
 * класс для конвертации DTO <-> Model сущности Автомобиль
 */

public class CarDTOConverter{

    /**
     * Конвертация из DTO объекта в модель, храняющуюся в бд
     * @param carDTO - данные автомобиля ДТО
     * @return - возвращает объект автомобиля
     */
    public static Car fromDTO(CarDTO carDTO){
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        return car;
    }

    /**
     * Конвертация из модели, хранящейся в бд, в DTO объект
     * @param car - объект автомобиль
     * @return - ДТО объект автомобиль
     */
    public static CarDTO toDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        return carDTO;
    }

}
