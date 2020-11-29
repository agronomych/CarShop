package ru.agronomych.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.agronomych.controller.dto.ClientDTO;

import java.util.Locale;

/**
 * Класс для валидации данных по клиенту
 */
@Component
public class ClientValidator implements Validator {

    private final static Logger logger = LogManager.getLogger(ClientValidator.class);
    MessageSource messageSource;

    public ClientValidator(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientDTO.class.equals(clazz);
    }

    /**
     * Валидация: имя, фамилия и пасспорт для клиента обязательны
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ClientDTO toCheck = (ClientDTO) target;
        if (toCheck.getName().isEmpty()){
            logger.error("Client's name and lastname are neccessary");
            String message = messageSource.getMessage("name.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("name", "name.empty", message);
        }
        if (toCheck.getLastName().isEmpty()){
            logger.error("Client's name and lastname are neccessary");
            String message = messageSource.getMessage("name.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("lastName", "name.empty", message);
        }

        if (toCheck.getPassport().isEmpty()){
            logger.error("Client's passport is null");
            String message = messageSource.getMessage("passport.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("passport", "passport.empty", message);
        }
    }
}
