package org.example.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface NameValidation {
    String validate() default "^\\w+\\s\\w+[\\s\\w*]*$";
}
