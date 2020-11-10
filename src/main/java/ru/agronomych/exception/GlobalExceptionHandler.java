package ru.agronomych.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.agronomych.controller.ResponseError;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    /**
     * Обработка ошибок типа "неверный аргумент"
     * @param exception
     * @return
     */
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

    /**
     * Обработка непроверяемых исключений
     * @param exception
     * @return
     */
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


    /**
     * Обработка проверяемых исключений
     * @param exception
     * @return
     */
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

    /**
     * обработка исключения после валидации полей managerId, clientId, carId
     * @param exception
     * @return
     */
    @ExceptionHandler(UnknownIdException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseError> UnknownIdException(UnknownIdException exception){
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "UnknownIDs",
                exception.getMessage(),
                "CarShop"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * обработка исключения нулевой или отсутствующей суммы контракта
     * @param exception
     * @return
     */
    @ExceptionHandler(ZeroContractException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseError> ZeroContractException(ZeroContractException exception){
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "ZeroContract",
                exception.getMessage(),
                "CarShop"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
