package org.example.validators;

import org.example.annotations.*;
import java.lang.reflect.Field;
import java.text.Annotation;

@Validator
public class MyValidator {
    private static final String INVALID_EMAIL_MESSAGE = "Invalid email";
    private static final String INVALID_NAME_MESSAGE = "Invalid name";
    private static final String INVALID_POSITION_MESSAGE = "Invalid name";

    public static void validate(Object object) {
        if(!object.getClass().isAnnotationPresent(Validatable.class)) {
            System.out.println("Incorrect object to validate");
            return;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field: fields) {
            if(field.isAnnotationPresent(NameValidation.class)) {
                validateName(field, object);
            }
            else if(field.isAnnotationPresent(EmailValidation.class)) {
                validateEmail(field, object);
            }
            else if(field.isAnnotationPresent(PositionValidation.class)) {
                validatePosition(field, object);
            }
        }
    }

    private static void validatePosition(Field position, Object object) {
        try {
            position.setAccessible(true);
            if(!((String) position.get(object)).trim().matches(position.getAnnotation(PositionValidation.class).validate())) {
                throw new RuntimeException();
            }
        } catch (IllegalAccessException | RuntimeException e) {
            throw new RuntimeException(INVALID_POSITION_MESSAGE);
        }
    }

    private static void validateEmail(Field email, Object object) {
        try {
            email.setAccessible(true);
            if(!((String) email.get(object)).trim().matches(email.getAnnotation(EmailValidation.class).validate())) {
                throw new RuntimeException();
            }
        } catch (IllegalAccessException | RuntimeException e) {
            throw new RuntimeException(INVALID_EMAIL_MESSAGE);
        }
    }

    private static void validateName(Field name, Object object) {
        try {
            name.setAccessible(true);
            if(!((String) name.get(object)).trim().matches(name.getAnnotation(NameValidation.class).validate())) {
                throw new RuntimeException();
            }
        } catch (IllegalAccessException | RuntimeException e) {
            throw new RuntimeException(INVALID_NAME_MESSAGE);
        }
    }
}
