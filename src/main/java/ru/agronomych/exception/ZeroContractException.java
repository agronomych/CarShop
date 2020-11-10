package ru.agronomych.exception;

public class ZeroContractException extends RuntimeException{

    private String message = "";

    public ZeroContractException(String message){
        super(message);
    }
}
