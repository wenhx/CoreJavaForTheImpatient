package ch02;

public class E17 {
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

        Queue.Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
    }
}
