package org.example;

import org.example.validators.MyValidator;

import java.io.*;
import java.util.List;

public class DeserializationUtil {
    public static Object deserializeList(File file, Class clazz) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file));
        List<Object> myList = (List<Object>) objectInputStream.readObject();


        for(Object object: myList) {
            MyValidator.validate(clazz.cast(object));
        }

        return myList;
    }
}
