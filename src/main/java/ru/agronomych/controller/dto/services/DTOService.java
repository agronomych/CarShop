package ru.agronomych.controller.dto.services;

import java.util.HashMap;

/**
 * общий интерфейс для работы со слоем DTO
 */
public interface DTOService<DTO,Model,PK>{

    /**
     * метод конвертации DTO в DAO
     * @param dtoData
     * @return some Model class
     */
    public Model fromDTO(DTO dtoData);

    /**
     * метод конвертации DTO в DAO
     * @param model
     * @return some DTO class
     */
    public DTO toDTO(Model model);

    /**
     * метод добавления объекта "автомобиль"
     * @param dto
     */
    public void add(DTO dto);

    /**
     * метод получения объекта первичному ключу
     * @param id
     * @return some DTO object
     */
    public DTO get(PK id);

    /**
     * метод получения всех объектов одного вида сущностей
     * @return HashMap объектов одного вида сущности (зависит от имплементации)
     */
    public HashMap<PK,DTO> getAll();

    /**
     * метод удаления объекта по первичному ключу
     * @param id
     */
    public void delete(PK id);

    /**
     * метод обновления данных объекта
     * @param body
     */
    public void update(DTO body);

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
