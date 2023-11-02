package ch09.e13;

import java.io.*;
import java.util.Objects;

public class E13 {
    public static void run() {
        try {
            Student s1 = new Student("S1", 20);
            Student s2 = clone(s1);
            System.out.println(s1 == s2);
            System.out.println(Objects.equals(s1, s2));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
                T result = (T)ois.readObject();
                return result;
            }
        }
    }
}
