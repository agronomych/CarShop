package ru.agronomych.controller;

import java.util.UUID;

public class UnknownID extends ResponseError{

    private final String explanation = "Check managerId";

    public UnknownID(UUID id, String code, String message, String system) {
        super(id, code, message, system);
    }
}
