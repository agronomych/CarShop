package ru.agronomych.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.LocaleResolver;
import ru.agronomych.controller.dto.CarDTO;

import java.util.Locale;

/**
 * Класс для валидации данных по автомобилю
 */
@Component
public class CarValidator implements Validator {

    private static final Logger logger = LogManager.getLogger(CarValidator.class.getName());
    MessageSource messageSource;

    public CarValidator(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CarDTO.class.equals(clazz);
    }

    /**
     * Валидация: id и указание модели для автомобиля обязательны
     * @param target входящий объект автомобиль для валидации
     * @param errors объект, куда будут сохранены ошибки
     */
    @Override
    public void validate(Object target, Errors errors) {
        CarDTO toCheck = (CarDTO) target;
        if (toCheck.getId().isEmpty()){
            logger.error("id is empty");
            String message = messageSource.getMessage("id.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("id", "id.empty", message);
        }
        if (toCheck.getModel().isEmpty()){
            logger.error("model is empty");
            String message = messageSource.getMessage("model.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("model", "model.empty", message);
        }
    }
}
