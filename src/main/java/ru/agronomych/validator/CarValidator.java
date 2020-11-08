package ru.agronomych.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.agronomych.controller.dto.CarDTO;

import java.util.Locale;

@Component
public class CarValidator implements Validator {

    private final static Logger logger = LogManager.getLogger(CarValidator.class);
    @Autowired
    MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return CarDTO.class.equals(clazz);
    }

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
