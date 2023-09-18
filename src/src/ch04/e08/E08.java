package ch04.e08;

import java.util.ArrayList;
import java.util.function.Function;

public class E08 {
    public static void run() {
        int[] intArray = new int[10];
        Class<? extends int[]> class1 = intArray.getClass();
        ArrayList<Integer> integers = new ArrayList<>();
        Class<? extends ArrayList> class2 = integers.getClass();
        Order order = new Order();
        order.addItem(1);
        Order.Item item = order.getItem(1);
        Class<? extends Order.Item> class3 = item.getClass();
        Class<? extends Integer> class4 = int.class;
        ClassDescription[] classes = new ClassDescription[] {
                new ClassDescription("Array", class1),
                new ClassDescription("Generic Types", class2),
                new ClassDescription("Inner Classes", class3),
                new ClassDescription("Primitive Types", class4)
        };
        print(classes, Class::getCanonicalName, "Class::getCanonicalName");
        print(classes, Class::getSimpleName, "Class::getSimpleName");
        print(classes, Class::getTypeName, "Class::getTypeName");
        print(classes, Class::getName, "Class::getName");
        print(classes, Class::toString, "Class::toString");
        print(classes, Class::toGenericString, "Class::toGenericString");
    }

    public static void print(ClassDescription[] classes, Function<Class, String> getString, String methodName) {
        System.out.println(methodName);
        for (ClassDescription c : classes) {
            System.out.printf("%s: %s%n", c.description, getString.apply(c.aClass));
        }
        System.out.println("---------------------------------------");
    }

    public static class ClassDescription {
        private String description;
        private Class aClass;

        public ClassDescription(String name, Class aClass) {
            this.description = name;
            this.aClass = aClass;
        }
    }
}
