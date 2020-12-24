package ru.agronomych.exception;

/**
 * исключение, которое бросается в случае нулевой суммы контракта
 */
public class ZeroContractException extends RuntimeException{

    private String message = "";

    /**
     * Бросает исключение при  нулевой сумме контракта
     * @param message сообщение об ошибке
     */
    public ZeroContractException(String message){
        super(message);
    }
}
