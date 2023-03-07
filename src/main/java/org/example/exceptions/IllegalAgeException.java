package org.example.exceptions;

public class IllegalAgeException extends IllegalInputException{
    public IllegalAgeException() {
        super("Age does not match criteria!");
    }

    public IllegalAgeException(String message) {
        super(message);
    }

}
