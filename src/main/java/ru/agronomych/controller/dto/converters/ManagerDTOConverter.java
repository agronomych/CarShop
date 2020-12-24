package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.model.Manager;

/**
 * класс для конвертации DTO <-> Model сущности Менеджер
 */

public class ManagerDTOConverter{

    /**
     * Конвертация из DTO объекта в модель, храняющуюся в бд
     * @param managerDTO данные менеджера ДТО
     * @return - возвращает объект менеджера
     */
    public static Manager fromDTO(ManagerDTO managerDTO){
        Manager manager = new Manager();
        manager.setId((managerDTO.getId()));
        manager.setLastName(managerDTO.getLastName());
        manager.setName(managerDTO.getName());
        manager.setPatronymic(managerDTO.getPatronymic());
        return manager;
    }

    /**
     * Конвертация из модели, хранящейся в бд, в DTO объект
     * @param manager - объект менеджер
     * @return - ДТО объект менеджера
     */
    public static ManagerDTO toDTO(Manager manager){
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setLastName(manager.getLastName());
        managerDTO.setName(manager.getName());
        managerDTO.setPatronymic(manager.getPatronymic());
        return managerDTO;
    }
}
