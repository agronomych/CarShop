package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ManagerDTO;
import ru.agronomych.model.ManagerModel;

/**
 * класс для конвертации DTO <-> Model сущности Менеджер
 */

public class ManagerDTOConverter{

    /**
     * Конвертация из DTO объекта в модель, храняющуюся в бд
     * @param managerDTO
     * @return
     */
    public static ManagerModel fromDTO(ManagerDTO managerDTO){
        ManagerModel manager = new ManagerModel();
        manager.setId((managerDTO.getId()));
        manager.setLastName(managerDTO.getLastName());
        manager.setName(managerDTO.getName());
        manager.setPatronymic(managerDTO.getPatronymic());
        return manager;
    }

    /**
     * Конвертация из модели, хранящейся в бд, в DTO объект
     * @param manager
     * @return
     */
    public static ManagerDTO toDTO(ManagerModel manager){
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setLastName(manager.getLastName());
        managerDTO.setName(manager.getName());
        managerDTO.setPatronymic(manager.getPatronymic());
        return managerDTO;
    }
}
