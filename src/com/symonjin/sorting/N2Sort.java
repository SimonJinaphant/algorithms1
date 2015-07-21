package com.symonjin.sorting;

public class N2Sort extends Sort {

    /*
        Bubble Sort:
        For every iteration i: loop through the entire array by consecutive pairs.
        If the pairing element are not in order, swap them.
     */
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

            //Optimization: If no exchanges were made, the array is already sorted
            if (!exchangeFlag) break;
        }
    }

    /*
        Insertion sort:
        For every iteration i, if the next element is smaller,
        keep moving that element left until it is at its correct place.
     */

    public static <T extends Comparable<? super T>> void insertionSort(T[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while (j > 0 && less(input[j], input[j - 1])) {
                swap(input, j, j - 1);
                j--;
            }
        }

    }

    /*
        Selection sort:
        For every iteration i, find the smallest element and swap it with the element at i
     */
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
