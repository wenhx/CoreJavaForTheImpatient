package ch07.e03;

import java.util.HashSet;
import java.util.Set;

public class E03 {
    public static void run() {
        Set<Integer> set1 = Set.of(1, 2, 3, 4, 5, 6);
        Set<Integer> set2 = Set.of(5, 6, 7, 8, 9, 10);
        System.out.println("Set1:");
        printSet(set1);
        System.out.println("Set2:");
        printSet(set2);
        doUnion(set1, set2);
        doIntersection(set1, set2);
        doDifference(set1, set2);
    }

    private static void doUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        System.out.println("The union:");
        printSet(result);
    }

    private static void doIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        System.out.println("The intersection:");
        printSet(result);
    }

    private static void doDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result1 = new HashSet<>(set1);
        result1.removeAll(set2);
        Set<Integer> result2 = new HashSet<>(set2);
        result2.removeAll(set1);
        HashSet<Integer> result = new HashSet<>();
        result.addAll(result1);
        result.addAll(result2);
        System.out.println("The difference:");
        printSet(result);
    }

    private static void printSet(Set<Integer> set) {
        for (Integer i : set) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
