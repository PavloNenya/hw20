package org.example;

import org.example.exceptions.*;

import java.util.function.Predicate;

public enum VALIDATION_CRITERIA {
    EMAIL((Predicate<String>) s -> s.trim().matches("^[\\w.]+@[\\w.]+\\.((com)|(edu)|(net)|(org))$"), new IllegalEmailException()),
    NAME((Predicate<String>) s -> s.trim().matches("^\\w+\\s\\w+[\\s\\w*]*$"), new IllegalNameException()),
    POSITION((Predicate<String>) s -> s.trim().matches("^(Junior)|(Middle)|(Senior)$"), new IllegalPositionException()),
    AGE((Predicate<Integer>) i -> i > 18 && i < 50, new IllegalAgeException());

    final Predicate predicate;

    final IllegalInputException exception;

    <T> VALIDATION_CRITERIA(Predicate<T> validationPattern, IllegalInputException exception) {
        this.predicate = validationPattern;
        this.exception = exception;
    }

    public void throwException() throws IllegalInputException {
        throw exception;
    }

    public boolean validateField(Object fieldValue) {
        return predicate.test(fieldValue);
    }
}
