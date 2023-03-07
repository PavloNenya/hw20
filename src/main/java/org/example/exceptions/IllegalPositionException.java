package org.example.exceptions;

public class IllegalPositionException extends IllegalInputException{
    public IllegalPositionException() {
        super("Position does not match criteria!");
    }

    public IllegalPositionException(String message) {
        super(message);
    }

}