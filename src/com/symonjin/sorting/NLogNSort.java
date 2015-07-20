package com.symonjin.sorting;


public class NLogNSort extends Sort{

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




    public static <T extends Comparable<? super T>> void quickSort(Comparable[] input){
        qsort(input, 0, input.length -1);
    }

    private static <T extends Comparable<? super T>> void qsort(
            Comparable[] input, int lower, int upper){

        if(upper <= lower) return;
        int j = Sort.partition(input, lower, upper);
        qsort(input, lower, j - 1);
        qsort(input, j + 1, upper);
    }



    public static <T extends Comparable<? super T>> void threeWayQuickSort(T[] input){
        threeWayQsort(input, 0, input.length -1);
    }

    private static <T extends Comparable<? super T>> void threeWayQsort(
            T[] input, int lower, int upper){

        if(upper <= lower) return;
        int lesser = lower, greater = upper;
        T pivot = input[lower];
        int i = lower;

        while(i <= greater){
            int result = input[i].compareTo(pivot);
            if(result < 0){
                swap(input, lesser++, i++);
            }else if (result > 0){
                swap(input, i, greater--);
            }else{
                i++;
            }
        }

        threeWayQsort(input, lower, lesser - 1);
        threeWayQsort(input, greater + 1, upper);
    }

}