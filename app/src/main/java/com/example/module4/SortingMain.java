package com.example.pavel2.module4;

import java.util.Arrays;

public class SortingMain {
    public static void bubbleSort(int[] data) {
        for (int i = data.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int x = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = x;
                    System.out.println(Arrays.toString(data));
                }
            }
        }
    }

    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int current = data[i];
            int prevKey = i - 1;
            while (prevKey >= 0 && data[prevKey] > current) {
                data[prevKey + 1] = data[prevKey];
                prevKey--;

                System.out.println(Arrays.toString(data));
            }
            data[prevKey + 1] = current;
            System.out.println(Arrays.toString(data));
        }
    }

    public static void quickSort(int[] data, int low, int high) {
        if (data.length == 0) return;
        if (low >= high) return;
        int mid = low +     (high - low)/ 2;
        int op = data[mid];
        int i = low;int j = high;
        while (i < j) {
            while (data[i] < op) {
                i++;
            }
            while (data[j] > op) {
                j--;
            }
            if (j >= i) {
                int x = data[j];
                data[j] =data[i];
                data[i] = x;
                i++;
                j--;

                System.out.println(Arrays.toString(data));
            }
            if (j > low) quickSort(data, low, j);
            if (high > i) quickSort(data, i, high);

        }
    }

    public static void main(String[] args) {
        int[] numbers = {6,2,4,5,1,9,8,3,7};
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers,0,numbers.length-1);
    }
}
