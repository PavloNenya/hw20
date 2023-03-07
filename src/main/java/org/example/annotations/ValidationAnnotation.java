package org.example.annotations;


import org.example.VALIDATION_CRITERIA;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface ValidationAnnotation {
    VALIDATION_CRITERIA validation();

}
