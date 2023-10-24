package ch08.e14;

public class AverageAccumulator {
    private double sum = 0;
    private double count = 0;

    public AverageAccumulator(double sum, double count) {
        this.sum = sum;
        this.count = count;
    }

    public AverageAccumulator add(double number) {
        return new AverageAccumulator(this.sum + number, this.count + 1);
    }

    public AverageAccumulator add(AverageAccumulator avg2) {
        return new AverageAccumulator(this.sum + avg2.sum, this.count + avg2.sum);
    }

    public double getSum() {
        return sum;
    }

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return sum / count;
    }
}
