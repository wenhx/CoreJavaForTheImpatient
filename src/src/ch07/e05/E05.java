package ch07.e05;

import java.util.*;

public class E05 {
    public static void run() {
        Test1();
        Test2();
    }

    private static void Test2() {
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        swap(list, 0, 5);
        printList(list);
    }

    private static void Test1() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        swap(list, 0, 5);
        printList(list);
    }

    private static void printList(List<?> list) {
        for (Object o : list) {
            System.out.print(o + ", ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");
    }

    public static void swap(List<?> list, int i, int j) {
        if (i == j)
            return;
        if (i < 0 || i >= list.size() || j < 0 || j >= list.size())
            throw new IndexOutOfBoundsException();

        if (list instanceof RandomAccess) {
            swapElements(list, i, j);
            return;
        }

        swapSequential(list, i, j);
    }

    private static <T> void swapSequential(List<T> list, int i, int j) {
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        ListIterator<T> iterator = list.listIterator();
        T first = null;
        T second = null;
        int index = 0;
        while (iterator.hasNext()) {
            System.out.println("Iterate " + index);
            if (index == i) {
                first = iterator.next();
            } else if (index == j) {
                second = iterator.next();
                iterator.set(first);
                break;
            } else {
                iterator.next();
            }
            index++;
        }
        iterator = list.listIterator();
        index = 0;
        while (iterator.hasNext()) {
            System.out.println("Iterate " + index);
            iterator.next();
            if (index == i) {
                iterator.set(second);
                break;
            }
            index++;
        }
    }

    private static <T> void swapElements(List<T> list, int i, int j) {
        T e = list.get(i);
        list.set(i, list.get(j));
        list.set(j, e);
    }
}
