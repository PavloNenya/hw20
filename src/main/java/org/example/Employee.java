package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.example.annotations.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
@FieldNameConstants
@Validatable
public class Employee implements Serializable {
    @ValidationAnnotation(validate = VALIDATION_CRITERIA.EMAIL)
    String email;

    @ValidationAnnotation(validate = VALIDATION_CRITERIA.NAME)
    @NonNull
    final String name;

    @ValidationAnnotation(validate = VALIDATION_CRITERIA.POSITION)
    String position;

    @ValidationAnnotation(validate = VALIDATION_CRITERIA.AGE)
    int age;
}
