package ru.agronomych.exception;


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
