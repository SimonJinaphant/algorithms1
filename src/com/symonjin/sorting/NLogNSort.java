package com.symonjin.sorting;


import java.util.Comparator;

public class NLogNSort {

    public static <T extends Comparable<? super T>> void mergeSort(T[] input) {
        T[] auxilary = (T[]) new Comparable[input.length];
        sort(input, auxilary, 0, input.length - 1);
    }

    public static <T extends Comparable<? super T>> void merge(
            T[] input, T[] auxilary, int lower, int middle, int upper) {

        for (int k = lower; k <= upper; k++) {
            auxilary[k] = input[k];
        }

        int i = lower, j = middle + 1;
        for (int k = lower; k <= upper; k++) {
            //When one partition has been fully iterated through,
            //copy the remaining elements from the other partition
            if (i > middle) {
                input[k] = auxilary[j++];
            } else if (j > upper) {
                input[k] = auxilary[i++];
            } else if (less(auxilary[j], auxilary[i])) {
                //Otherwise, compare the elements and add the smallest one
                input[k] = auxilary[j++];
            } else {
                input[k] = auxilary[i++];
            }
        }

    }

    public static <T extends Comparable<? super T>> void sort(
            T[] input, T[] auxilary, int lower, int upper) {
        if (upper <= lower) {
            //Recursion base case: sub-array has only 1 element
            return;
        }
        int middle = lower + (upper - lower) / 2;
        sort(input, auxilary, lower, middle);
        sort(input, auxilary, middle + 1, upper);

        if (!less(input[middle + 1], input[middle])) {
            //Early return because array is already sorted;
            return;
        }

        merge(input, auxilary, lower, middle, upper);
    }

    public static <T extends Comparable<? super T>> int partition(
            Comparable[] input, int lower, int upper){
        
        //Lowerbound element is the pivoting element
        int i = lower, j = upper + 1;
        while(i <= j){
            while(less(input[++i], input[lower])){
                if(i == upper) break;
            }
            while(less(input[lower], input[--j])){
                if(j == lower) break;
            }
            if(i >= j) break;
            swap(input, i, j);
        }

        swap(input, lower, j);
        return j;
    }

    public static <T extends Comparable<? super T>> void quickSort(Comparable[] input){
        qsort(input, 0, input.length -1);
    }

    private static <T extends Comparable<? super T>> void qsort(
            Comparable[] input, int lower, int upper){

        if(upper <= lower) return;
        int j = partition(input, lower, upper);
        qsort(input, lower, j-1);
        qsort(input, j+1, upper);
    }


    private static <T extends Comparable<? super T>> boolean less(T left, T right) {
        return left.compareTo(right) == -1;
    }

    private static <T extends Comparable<? super T>> void swap(T[] input, int a, int b) {
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}