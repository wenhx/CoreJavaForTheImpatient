package ch10.e04;

import java.util.Arrays;

public class Matrix {
    private final long[][] data;


    public Matrix(long a, long b, long c, long d) {
        this.data = new long[][] {{a, b}, {c, d}};
    }

    public Matrix multiply(Matrix other) {
        long a = data[0][0] * other.data[0][0] + data[0][1] * other.data[1][0]; // 0,0
        long b = data[0][0] * other.data[0][1] + data[0][1] * other.data[1][1]; // 0,1
        long c = data[1][0] * other.data[0][0] + data[1][1] * other.data[1][0]; // 1,0
        long d = data[1][0] * other.data[0][1] + data[1][1] * other.data[1][1]; // 1,1
        return new Matrix(a, b, c, d);
    }

    public static Matrix identity() {
        return new Matrix(1, 0, 0, 1);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }

    public long[][] getData() {
        return this.data;
    }
}
