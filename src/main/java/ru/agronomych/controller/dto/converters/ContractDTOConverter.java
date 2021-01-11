package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.domain.Contract;

/**
 * класс для конвертации DTO <-> Model сущности Контракт
 */

public class ContractDTOConverter{

    /**
     * Преобразовывает DTO в Model для сохранения в БД
     * @param contractDTO данные контракта ДТО
     * @param car данные автомобиля
     * @param client данные автомобиля
     * @param manager данные автомобиля
     * @return - возвращает объект контракта
     */
    public static Contract fromDTO(ContractDTO contractDTO,
                                   String car,
                                   Long client,
                                   Long manager){
        Contract contract = new Contract();
        contract.setId(contractDTO.getId());
        contract.setSum(contractDTO.getSum());
        contract.setDate(contractDTO.getDate());
        contract.setCar(car);
        contract.setClient(client);
        contract.setManager(manager);
        return contract;
    }

    /**
     * Преобразовывает Model в DTO для отправки на фронт
     * @param contract Объект контракта
     * @param carID уникальный идентификатор машины из контракта
     * @param clientID уникальный идентификатор клиента из контракта
     * @param managerID уникальный идентификатор менеджера из контракта
     * @return - возвращает ДТО контракта
     */
    public static ContractDTO toDTO(Contract contract,
                                    String carID,
                                    Long clientID,
                                    Long managerID
                                    ){
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCarId(contract.getCar());
        contractDTO.setClientId(contract.getClient());
        contractDTO.setManagerId(contract.getManager());
        contractDTO.setDate(contract.getDate());
        contractDTO.setSum(contract.getSum());
        contractDTO.setId(contract.getId());
        return contractDTO;
    }

}
