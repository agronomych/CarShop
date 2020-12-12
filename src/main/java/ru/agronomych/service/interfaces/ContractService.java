package ru.agronomych.service.interfaces;

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
     * добавляет список контрактов
     * @param list
     */
    public  void addAll(List<ContractDTO> list);

    /**
     * получает все контракты
     * @return - возвращает список всех контрактов
     */
    public List<ContractDTO> getAll();

    /**
     * получает контракт по id
     * @param id - уникальный идентификатор, по которому будет получен контракт
     * @return - полученный контракт
     */
    public ContractDTO getById(Long id);

    /**
     * удаляет контракт по id
     * @param id - уникальный идентификатор контракта, который будет удалён
     */
    public void deleteById(Long id);

    /**
     * обновляет данные контракта
     * @param contract - обновлённые данные
     */
    public void update(ContractDTO contract);

    /**
     * Получает список уникальный идентификаторов контрактов
     * @return список уникальных идентификаторов контрактов
     */
    public List<Long> getIDs();
}
