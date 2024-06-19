package com.example.pavel2.module4;

public class RecursMain {

    public static double pow(double x, int n) {
        double value = 1;
        if (n > 0) {
        value = x * pow(x, n -1);
        } else if (n <0) {
            value = 1.0 / pow(x, -1 * n);
        }
        return value;
    }
    public static void main(String[] args) {
    double result = pow(10,-3);
        System.out.println(result);
    }
}
