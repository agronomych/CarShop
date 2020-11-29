package ru.agronomych.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.exception.UnknownIdException;
import ru.agronomych.exception.ZeroContractException;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ManagerService;

import java.util.Locale;

/**
 * Класс для валидации данных по контракту
 */
@Component
public class ContractValidator implements Validator {

    private final static Logger logger = LogManager.getLogger(ClientValidator.class);

    private MessageSource messageSource;
    private CarService carService;
    private ManagerService managerService;
    private ClientService clientService;

    public ContractValidator(MessageSource messageSource,
                             CarService carService,
                             ManagerService managerService,
                             ClientService clientService){
        this.messageSource = messageSource;
        this.carService = carService;
        this.managerService = managerService;
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ContractDTO.class.equals(clazz);
    }

    /**
     * Валидация: указанные менеджер, клиент и автомобиль должны уже быть заведены в бд до этого
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) throws UnknownIdException, ZeroContractException{

        ContractDTO contractDTO = (ContractDTO) target;

        if (managerService.getAllManagers().isEmpty() || !managerService.getAllManagers().containsKey(contractDTO.getManagerId())){
            logger.error("Unknown manager");
            String message = messageSource.getMessage("manager.unknown", new Object[]{}, Locale.getDefault());
            errors.rejectValue("managerId", "manager.unknown", message);
        }

        if (clientService.getAllClients().isEmpty() || !clientService.getAllClients().containsKey(contractDTO.getClientId())){
            logger.error("Unknown client");
            String message = messageSource.getMessage("client.unknown", new Object[]{}, Locale.getDefault());
            errors.rejectValue("clientId", "client.unknown", message);
        }

        if (carService.getAllCars().isEmpty() || !carService.getAllCars().containsKey(contractDTO.getCarId())){
            logger.error("Unknown manager");
            String message = messageSource.getMessage("car.unknown", new Object[]{}, Locale.getDefault());
            errors.rejectValue("carId", "car.unknown", message);
        }
        if (errors.getErrorCount()>0){
            throw new UnknownIdException(errors);
        }
        if (contractDTO.getSum() == null || (contractDTO.getSum().longValue() == 0)) {
            String message = messageSource.getMessage("sum.zero", new Object[]{}, Locale.getDefault());
            throw new ZeroContractException(message);
        }
    }
}
