package ch02;

public class E16 {
    public static void run() {
        Queue queue = new Queue();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Fore");
        queue.add("Five");
        queue.add("Six");
        queue.add("Seven");
        queue.add("Eight");
        queue.add("Nine");
        queue.add("Ten");

        while (true) {
            String value = queue.remove();
            if (value == null)
                break;

            System.out.println(value);
        }
    }
}
