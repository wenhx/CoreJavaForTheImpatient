package ch03.e08;

public class Greeter implements Runnable {
    private int times;
    private String target;

    public Greeter(int times, String target) {
        this.times = times;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("Hello, " + target);
        }
    }
}
