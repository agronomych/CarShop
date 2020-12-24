package ru.agronomych.service;

import ru.agronomych.controller.dto.CarDTO;

import java.util.List;

/**
 * Сервис работоы с автомобилем
 *
 * @author Anton_Suryapin
 */
public interface CarService {

    /**
     * добавляет автомобиль
     * @param car - автомобиль, который будет добавлен
     */
    void add(CarDTO car);

    /**
     * Возвращает все автомобили
     * @return
     */
    List<CarDTO> getAll();

    /**
     * получить автомобиль
     * @param id - уникальный идентификатор, по которому надо получить автомобиль
     * @return - полученный автомобиль
     */
    CarDTO getById(String id);

    /**
     * удаляет автомобиль
     * @param id - уникальный идентификатор автомобиля, который будет удалён
     */
    void deleteById(String id);

    /**
     * Обновляет данные автомобиля
     * @param car - обновлённые данные автомобиля
     */
    void update(CarDTO car);

    /**
     * Получает список уникальный идентификаторов автомобилей
     * @return список уникальных идентификаторов автомобилей
     */
    List<String> getIDs();
}