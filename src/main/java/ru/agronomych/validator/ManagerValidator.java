package ru.agronomych.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.agronomych.controller.dto.ManagerDTO;

import java.util.Locale;

/**
 * Класс для валидации данных по менеджеру
 */
@Component
public class ManagerValidator implements Validator {


    private final static Logger logger = LogManager.getLogger(ClientValidator.class);

    MessageSource messageSource;

    public ManagerValidator(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ManagerDTO.class.equals(clazz);
    }

    /**
     * Валидация: имя и фамилия у менеджера обязательны
     * @param target входящий объект менеджер для валидации
     * @param errors объект, куда будут сохранены ошибки
     */
    @Override
    public void validate(Object target, Errors errors) {
        ManagerDTO toCheck = (ManagerDTO) target;
        if (toCheck.getName().isEmpty()){
            logger.error("Manager's name and lastname are neccessary");
            String message = messageSource.getMessage("employeename.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("name", "employee.empty", message);
        }
        if (toCheck.getLastName().isEmpty()){
            logger.error("Manager's name and lastname are neccessary");
            String message = messageSource.getMessage("employeename.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("lastname", "employeename.empty", message);
        }
    }
}
