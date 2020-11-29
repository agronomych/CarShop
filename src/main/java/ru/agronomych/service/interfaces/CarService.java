package ru.agronomych.service.interfaces;

import ru.agronomych.model.CarModel;

import java.util.HashMap;

/**
 * Сервис работоы с автомобилем
 *
 * @author Anton_Suryapin
 */
public interface CarService {

    /**
     * добавляет автомобиль в
     */
    public void addCar(CarModel car);

    /**
     * добавить группу автомобилей
     */
    public  void addAllCars(HashMap<String, CarModel> map);

    /**
     * получить все автомобили
     */
    public HashMap<String, CarModel> getAllCars();

    /**
     * получить автомобиль по id
     */
    public CarModel getCarById(String id);

    /**
     * удалить автомобиль по id
     */
    public void deleteCarById(String id);

    public void updateCar(CarModel car);

    /**
     * метод сохранения всех данных в файлы
     * @return сообщение об успешном выполнении либо сообщение об ошибке
     */
    public String save();

    /**
     * метод загрузки всех данных из файла
     * @return сообщение об успешном выполнении либо сообщение об ошибке
     */
    public String load();

}
