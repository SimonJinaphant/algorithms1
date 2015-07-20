package com.symonjin.sorting;

public class NSort extends Sort {

    public static <T extends Comparable<? super T>> void bubbleSort(T[] input) {
        boolean exchangeFlag = false;

        for (int i = 0; i < input.length; i++) {
            exchangeFlag = false;

            for (int j = 0; j < input.length - 1; j++) {
                if (less(input[j + 1], input[j])) {
                    swap(input, j, j + 1);
                    exchangeFlag = true;
                }
            }

            if (!exchangeFlag) break;
        }
    }


    public static <T extends Comparable<? super T>> void insertionSort(T[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while (j > 0 && less(input[j], input[j - 1])) {
                swap(input, j, j - 1);
                j--;
            }
        }

    }


    public static <T extends Comparable<? super T>> void selectionSort(T[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (less(input[j], input[i])) {
                    swap(input, i, j);
                }
            }
        }
    }


}
