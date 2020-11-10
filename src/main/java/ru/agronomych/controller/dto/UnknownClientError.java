package ru.agronomych.controller.dto;

import ru.agronomych.controller.ResponseError;

import java.util.UUID;

public class UnknownClientError extends ResponseError {

    private final String message = "Check clientId";

    public UnknownClientError(UUID id, String code, String message, String system) {
        super(id, code, message, system);
    }

}
