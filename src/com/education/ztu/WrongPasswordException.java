package com.education.ztu;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Неправильний пароль");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}