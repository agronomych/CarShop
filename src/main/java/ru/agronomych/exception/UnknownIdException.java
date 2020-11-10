package ru.agronomych.exception;

/**
 * исключение после валидации полей managerId, clientId, carId
 * при бросании этого исключения передаётся параметр типа Errors, из текстов ошибок формируется общий текст ошибки
 * @param errors
 */

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class UnknownIdException extends RuntimeException{

    private String message = "";

    public UnknownIdException(Errors errors) {
        for(ObjectError error:errors.getAllErrors()){
            message+=error.getDefaultMessage()+" ";
        }
        throw new UnknownIdException(message);
    }

    private UnknownIdException(String message){
        super(message);
    }
}
