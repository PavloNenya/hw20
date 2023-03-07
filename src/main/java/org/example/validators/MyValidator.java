package org.example.validators;

import org.example.annotations.*;
import org.example.exceptions.IllegalInputException;

import java.lang.reflect.Field;

@Validator
public class MyValidator {

    public static void validate(Object object) throws IllegalInputException {
        if(!object.getClass().isAnnotationPresent(Validatable.class)) {
            System.out.println("Incorrect object to validate");
            return;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field: fields) {
            if(field.isAnnotationPresent(ValidationAnnotation.class)) {
                validateField(field, object);
            }
        }

    }

    private static void validateField(Field field, Object object) throws IllegalInputException {
        field.setAccessible(true);
        try {
            if(!field.getAnnotation(ValidationAnnotation.class).validate().validateField(field.get(object))) {
                field.getAnnotation(ValidationAnnotation.class).validate().throwException();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
