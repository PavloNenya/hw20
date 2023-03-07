package org.example;

import org.example.exceptions.IllegalInputException;
import org.example.validators.MyValidator;

import java.io.*;
import java.util.List;

public class SerialisationUtil {
    public static Object deserializeList(File file, Class clazz) throws IllegalInputException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file));
        List<Object> myList = (List<Object>) objectInputStream.readObject();


        for(Object object: myList) {
            MyValidator.validate(clazz.cast(object));
        }

        return myList;
    }

    public static void serializeList(File file, List list) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file));
        objectOutputStream.writeObject(list);
    }
}
