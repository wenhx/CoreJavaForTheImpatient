package ch06.e03;

public class E03 {
    public static void run() {
        Table<Integer, String> table = new Table<>();
        for (int i = 1; i <= 26; i++) {
            table.put(i, String.valueOf((char)(64 + i)));
        }
        System.out.println("---------------------------------");
        printTable(table);
        System.out.println("---------------------------------");
        for (int i = 1; i <= 26; i++) {
            System.out.printf("remove key=%d, value=%s, %s%n", i, table.get(i), table.remove(i));
        }
        System.out.println("---------------------------------");
        printTable(table);
    }

    private static void printTable(Table<Integer, String> table) {
        for (int i = 1; i <= 26; i++) {
            try {
                System.out.println(table.get(i));
            } catch (RuntimeException e) {
                System.out.printf("%s, key=%d%n", e.getMessage(), i);
            }

        }
    }
}
