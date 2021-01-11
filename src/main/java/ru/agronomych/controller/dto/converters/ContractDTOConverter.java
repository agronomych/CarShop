package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.domain.Car;
import ru.agronomych.domain.Client;
import ru.agronomych.domain.Contract;
import ru.agronomych.domain.Manager;

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
                                   Car car,
                                   Client client,
                                   Manager manager){
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
//     * @param carID уникальный идентификатор машины из контракта
//     * @param clientID уникальный идентификатор клиента из контракта
//     * @param managerID уникальный идентификатор менеджера из контракта
     * @return - возвращает ДТО контракта
     */
    public static ContractDTO toDTO(Contract contract
//                                    Car carID,
//                                    Client clientID,
//                                    Manager managerID
                                    ){
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setCarId(contract.getCar().getId());
        contractDTO.setClientId(contract.getClient().getId());
        contractDTO.setManagerId(contract.getManager().getId());
        contractDTO.setDate(contract.getDate());
        contractDTO.setSum(contract.getSum());
        contractDTO.setId(contract.getId());
        return contractDTO;
    }

}
