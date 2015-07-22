package com.symonjin.sorting;

import java.util.Arrays;

public class NLogNSort extends Sort {

    /**
     * Mergesort:
     * Sort the array by a divide and conquer technique where the array is broken
     * into smaller arrays and then merging it (in order) back together.
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] input) {
        T[] auxiliary = (T[]) new Comparable[input.length];
        sort(input, auxiliary, 0, input.length - 1);
    }


    public static <T extends Comparable<? super T>> void merge(
            T[] input, T[] auxiliary, int lower, int middle, int upper) {

        auxiliary = Arrays.copyOfRange(input, lower, upper);

        int i = lower, j = middle + 1;
        for (int k = lower; k <= upper; k++) {
            //When one partition has been fully iterated through,
            //copy the remaining elements from the other partition
            if (i > middle) {
                input[k] = auxiliary[j++];
            } else if (j > upper) {
                input[k] = auxiliary[i++];
            } else if (less(auxiliary[j], auxiliary[i])) {
                //Otherwise, compare the elements and append the smallest one
                input[k] = auxiliary[j++];
            } else {
                input[k] = auxiliary[i++];
            }
        }

    }


    public static <T extends Comparable<? super T>> void sort(
            T[] input, T[] auxiliary, int lower, int upper) {
        //Recursion base case: sub-array has only 1 element
        if (upper <= lower) return;

        //Recursively divide the array into two equal, or near-equal, sub-arrays
        int middle = lower + (upper - lower) / 2;
        sort(input, auxiliary, lower, middle);
        sort(input, auxiliary, middle + 1, upper);

        //Optimization: The array is already sorted, further operations not required
        if (!less(input[middle + 1], input[middle])) return;

        merge(input, auxiliary, lower, middle, upper);
    }


    /**
     * Bottom-Up mergesort:
     * An iterative implementation of mergesort, allthough slightly slower
     * than its recursive counterpart.
     */
    public static <T extends Comparable<? super T>> void iterMergesort(T[] input) {
        int N = input.length;
        T[] auxilary = (T[]) new Comparable[N];

        for (int size = 1; size < N; size *= 2) {
            for (int low = 0; low < N - size; low += (size * 2)) {
                merge(input, auxilary, low, low + size - 1, Math.min(low + 2 * size + 1, N - 1));
            }
        }

    }


    /**
     * Quicksort:
     * Recursively partition an array until it becomes 100% sorted.
     * In theory quicksort has more comparisons than mergesort,
     * but in practice it moves less data, making it faster in many situations.
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] input) {
        qsort(input, 0, input.length - 1);
    }


    private static <T extends Comparable<? super T>> void qsort(
            T[] input, int lower, int upper) {

        //Recursion base case: Input array is a single element
        if (upper <= lower) return;

        //Recursively partition the array
        int pivotIndex = Sort.partition(input, lower, upper);
        qsort(input, lower, pivotIndex - 1);
        qsort(input, pivotIndex + 1, upper);
    }


    /**
     * 3 Way Quicksort:
     * A variation of Quicksort that deals with duplicate keys more efficiently.
     */
    public static <T extends Comparable<? super T>> void threeWayQuickSort(T[] input) {
        threeWayQsort(input, 0, input.length - 1);
    }


    private static <T extends Comparable<? super T>> void threeWayQsort(
            T[] input, int lower, int upper) {

        //Recursion base case: Input array is a single element
        if (upper <= lower) return;

        //Two pointers to keep track of the index which borders the duplicate values
        int lesserThan = lower, greaterThan = upper;

        T pivot = input[lower];

        int i = lower;
        while (i <= greaterThan) {
            int result = input[i].compareTo(pivot);

            if (result < 0) {
                //Current element is smaller: increase the @lesserThan bound
                //and swap the element before moving on
                swap(input, lesserThan++, i++);
            } else if (result > 0) {
                //Current element is larger: decrease the @greaterThan bound
                //and swap the element, but don't move to yet as the swapped element
                //needs to be compared again
                swap(input, i, greaterThan--);
            } else {
                //Normally move onwards, if duplicates are present then this prevents
                //unnecessary movements
                i++;
            }
        }

        threeWayQsort(input, lower, lesserThan - 1);
        threeWayQsort(input, greaterThan + 1, upper);
    }

}