package ru.agronomych.service.interfaces;

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
    public void add(CarDTO car);

    /**
     * добавляет список автомобилей
     * @param list - список автомобилей, которые будет добавлены
     */
    public  void addAll(List<CarDTO> list);

    /**
     * Возвращает все автомобили
     * @return
     */
    public List<CarDTO> getAll();

    /**
     * получить автомобиль
     * @param id - уникальный идентификатор, по которому надо получить автомобиль
     * @return - полученный автомобиль
     */
    public CarDTO getById(String id);

    /**
     * удаляет автомобиль
     * @param id - уникальный идентификатор автомобиля, который будет удалён
     */
    public void deleteById(String id);

    /**
     * Обновляет данные автомобиля
     * @param car - обновлённые данные автомобиля
     */
    public void update(CarDTO car);

    /**
     * Получает список уникальный идентификаторов автомобилей
     * @return список уникальных идентификаторов автомобилей
     */
    public List<String> getIDs();
}
