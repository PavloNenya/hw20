package org.example.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface EmailValidation {
    String validate()default "^[\\w.]+@[\\w.]+\\.((com)|(edu)|(net)|(org))$";
}
