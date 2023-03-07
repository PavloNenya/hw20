package org.example;


import org.example.exceptions.IllegalInputException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalInputException {
        serialize();
        //desialize();
    }

    public static void serialize() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("pavel@gmail.com", "Pavlo Nenia", "Junior", 12));
        employeeList.add(new Employee("sodmfposm@gmail.org", "Ivan Ivanov", "Senior", 23));
        employeeList.add(new Employee("tyjd.agsdf@gmail.com", "Petro Petrov Petrovich", "Middle", 43));
        employeeList.add(new Employee("some.email@gmail.com", "Some Name", "Junior", 35));
        SerialisationUtil.serializeList(new File("src/main/resources/employees.txt"),employeeList);
    }

    public static void desialize() throws IllegalInputException, IOException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = (List<Employee>) SerialisationUtil.deserializeList(new File("src/main/resources/employees.txt"), Employee.class);

        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }

}