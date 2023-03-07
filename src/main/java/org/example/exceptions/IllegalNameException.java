package org.example.exceptions;

public class IllegalNameException extends IllegalInputException{
    public IllegalNameException() {
        super("Name does not match criteria!");
    }

    public IllegalNameException(String message) {
        super(message);
    }

}