package ru.agronomych.service.interfaces;

import ru.agronomych.model.ContractModel;
import ru.agronomych.model.ContractModel;

import java.util.HashMap;

/**
 * Сервис работоы с контрактом
 *
 * @author Anton_Suryapin
 */
public interface ContractService {

    /**
     * добавить контракт
     */
    void addContract(ContractModel contract);

    /**
     * добавить группу контрактов
     */
    public  void addAllContracts(HashMap<Long, ContractModel> map);

    /**
     * получить все контракты
     */
    public HashMap<Long, ContractModel> getAllContracts();

    /**
     * получить контракт по id
     */
    public ContractModel getContractById(Long id);

    /**
     * удалить контракт по id
     */
    public void deleteContractById(Long id);

    /**
     * обновить данные контракта по id
     */
    public void updateContract(ContractModel contract);

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
