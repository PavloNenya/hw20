package org.example.exceptions;

public class IllegalInputException extends Exception{
    public IllegalInputException() {
        super("Email does not match criteria!");
    }

    public IllegalInputException(String message) {
        super(message);
    }
}
