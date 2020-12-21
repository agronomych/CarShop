package ru.agronomych.service;

import ru.agronomych.controller.dto.ContractDTO;

import java.util.List;

/**
 * Сервис работоы с контрактом
 *
 * @author Anton_Suryapin
 */
public interface ContractService {

    /**
     * добавляет контракт
     * @param contract
     */
    void add(ContractDTO contract);

    /**
     * получает все контракты
     * @return - возвращает список всех контрактов
     */
    List<ContractDTO> getAll();

    /**
     * получает контракт по id
     * @param id - уникальный идентификатор, по которому будет получен контракт
     * @return - полученный контракт
     */
    ContractDTO getById(Long id);

    /**
     * удаляет контракт по id
     * @param id - уникальный идентификатор контракта, который будет удалён
     */
    void deleteById(Long id);

    /**
     * обновляет данные контракта
     * @param contract - обновлённые данные
     */
    void update(ContractDTO contract);

    /**
     * Получает список уникальный идентификаторов контрактов
     * @return список уникальных идентификаторов контрактов
     */
    List<Long> getIDs();
}