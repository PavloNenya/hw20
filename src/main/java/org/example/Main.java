package org.example;


import org.example.validators.MyValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = (List<Employee>) DeserializationUtil.deserializeList(new File("src/main/resources/employees.txt"), Employee.class);

        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }

}