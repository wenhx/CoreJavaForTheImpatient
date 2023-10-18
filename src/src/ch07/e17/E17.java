package ch07.e17;

import java.util.ArrayList;
import java.util.Collections;

public class E17 {
    public static void run() {
        Object list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = (ArrayList<Integer>)list1;
        list2.add(1);
        System.out.println(list2.get(0).getClass());
        Object list3 = Collections.checkedList(new ArrayList<>(), String.class);
        ArrayList<Integer> list4 = (ArrayList<Integer>)list3;
        list4.add(1);
        System.out.println(list4.get(0));
    }
}