package ru.agronomych.model;

/**
 * Представление сущности Клиент в системе
 */
public class Client extends Human{

    private String passport;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
