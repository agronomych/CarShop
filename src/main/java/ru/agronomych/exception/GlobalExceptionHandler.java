package ru.agronomych.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.agronomych.controller.ResponseError;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception){
        ResponseError responseError = new ResponseError(
                UUID.randomUUID(),
                "illegalArgumentException",
                exception.getLocalizedMessage(),
                "CarShop"
        );
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                exception.getLocalizedMessage(),
                "CarShop"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                "Неизвестная ошибка",
                "CarShop"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnknownIdException.class)
    public ResponseEntity<ResponseError> UnknownIdException(UnknownIdException exception){
        log.debug(exception.getLocalizedMessage(), exception);
        String fullError = exception.getMessage();
        /*for(ObjectError error:exception.getFullError()){
            fullError+=error.getDefaultMessage();
        }*/
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "UnknownIDs",
                exception.getMessage(),
                "CarShop"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
