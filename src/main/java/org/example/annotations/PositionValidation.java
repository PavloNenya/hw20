package org.example.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface PositionValidation {

    String validate() default "^(Junior)|(Middle)|(Senior)$";
}
