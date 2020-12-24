package ru.agronomych.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${systemName}")
    private String systemName;

    /**
     * Обработка ошибок типа "неверный аргумент"
     * @param exception исключение типа IllegalArgumentException
     * @return объект ResponseEntity с ошибкой и статусом BAD_REQUEST
     */
    @ExceptionHandler
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception){
        ResponseError responseError = new ResponseError(
                UUID.randomUUID(),
                "illegalArgumentException",
                exception.getLocalizedMessage(),
                systemName
        );
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Обработка непроверяемых исключений
     * @param exception исключение типа RuntimeException
     * @return объект ResponseEntity с ошибкой и статусом INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                exception.getLocalizedMessage(),
                systemName
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * Обработка проверяемых исключений
     * @param exception исключение типа Exception
     * @return объект ResponseEntity с ошибкой и статусом INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                "Неизвестная ошибка",
                systemName
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * обработка исключения после валидации полей managerId, clientId, carId
     * @param exception исключение типа UnknownIdException
     * @return объект ResponseEntity с ошибкой и статусом BAD_REQUEST
     */
    @ExceptionHandler(UnknownIdException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseError> UnknownIdException(UnknownIdException exception){
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "UnknownIDs",
                exception.getMessage(),
                systemName
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * обработка исключения нулевой или отсутствующей суммы контракта
     * @param exception исключение типа ZeroContractException
     * @return объект ResponseEntity с ошибкой и статусом BAD_REQUEST
     */
    @ExceptionHandler(ZeroContractException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseError> ZeroContractException(ZeroContractException exception){
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "ZeroContract",
                exception.getMessage(),
                systemName
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
