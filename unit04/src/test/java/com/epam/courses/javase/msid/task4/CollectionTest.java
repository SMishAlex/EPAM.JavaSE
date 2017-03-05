package com.epam.courses.javase.msid.task4;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CollectionTest {
    @Test
    public void testSerialiseAndDeserializeCorrect() throws IOException, ClassNotFoundException {
        Collection original = new Collection();
        Actor JK = new Actor("Jim Kerry");
        Actor EM = new Actor("Eddy Merfi");

        original.addFilm(new Film("Comedy", 100_000_000, JK, EM));
        try (FileOutputStream outputStream = new FileOutputStream("film collection.save");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(original);
        }
        Collection read;
        try (FileInputStream inputStream = new FileInputStream("film collection.save");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            read = (Collection) objectInputStream.readObject();
        }
        System.out.println(read);
        assertEquals(original, read);
    }

}