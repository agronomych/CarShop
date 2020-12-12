package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.model.Car;
import ru.agronomych.model.Client;
import ru.agronomych.model.Contract;
import ru.agronomych.model.Manager;

/**
 * класс для конвертации DTO <-> Model сущности Контракт
 */

public class ContractDTOConverter{

    /**
     * Преобразовывает DTO в Model для сохранения в БД
     * @param contractDTO
     * @param car
     * @param client
     * @param manager
     * @return
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
     * @param contract
     * @param carID
     * @param clientID
     * @param managerID
     * @return
     */
    public static ContractDTO toDTO(Contract contract,
                                    String carID,
                                    Long clientID,
                                    Long managerID
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
