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
    @EmailValidation
    String email;
    @NameValidation
    @NonNull
    final String name;

    @PositionValidation
    String post;

    int age;
}
