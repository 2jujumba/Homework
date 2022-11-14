package dev.jujumba;

import static java.lang.Math.*;

public class Main {
    private double[] X;
    private double[] Y;
    private final double A = -0.5;
    private final double B = 2;

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < main.getX().length; i++) {
            System.out.printf("i = %d, X = %f, Y = %f\n", i, main.getX()[i], main.getY()[i]);
        }
    }
    public Main() {
        iterFunction(0.0,3.0,0.004);
    }

    public Main(double start, double end, double delta) {
        iterFunction(start, end, delta);
    }
    public double function(double x) {
        if (x <= 0.7) return 1;
        if (x > 0.7 && x <= 1.4) return A * pow(x, 2) * log10(x);
        else return pow(E, A * x) * cos(B * x);
    }

    public int calculateSteps(double start, double end, double delta) {
        return (int) ((end - start) / delta) + 1; //[start, end]
    }

    public void iterFunction(double start, double end, double delta) {
        int size = calculateSteps(start, end, delta);
        X = new double[size];
        Y = new double[size];

        double x = start;
        double y;
        for (int i = 0; i < size; i++) {
            X[i] = x;
            y = function(x);
            Y[i] = y;
            x += delta;
        }
    }

    public double sumY() {
        double sum = 0;
        for (var y : Y) {
            sum += y;
        }
        return sum;
    }

    public double averageY() {
        return sumY() / (Y.length - 1);
    }
    public double getMaxY() {
        int index = 0;
        double max = Y[0];
        for (int i = 1; i < Y.length; i++) {
            if (Y[i] > max) {
                max = Y[i];
                index = i;
            }
        }
        System.out.printf("Max Y is:.. Index = %d, X = %f, Y = %f\n",index,X[index],Y[index]);
        return max;
    }

    public double getMinY() {
        int index = 0;
        double min = Y[0];
        for (int i = 1; i < Y.length; i++) {
            if (Y[i] < min) {
                min = Y[i];
                index = i;
            }
        }
        System.out.printf("Min Y is:.. Index = %d, X = %f, Y = %f\n",index,X[index],Y[index]);
        return min;
    }
    public double[] getX() {
        return X;
    }

    public double[] getY() {
        return Y;
    }
}
