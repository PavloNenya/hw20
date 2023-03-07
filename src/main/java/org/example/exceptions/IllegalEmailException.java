package org.example.exceptions;

public class IllegalEmailException extends IllegalInputException{
    public IllegalEmailException() {
        super("Email does not match criteria!");
    }

    public IllegalEmailException(String message) {
        super(message);
    }

}
