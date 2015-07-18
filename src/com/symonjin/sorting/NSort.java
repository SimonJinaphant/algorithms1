package com.symonjin.sorting;

public class NSort {

    public static <T extends Comparable<T>> void selectionSort(T[] input){
        for(int i = 0; i < input.length - 1; i++){
            for(int j = i+1; j < input.length; j++){
                if(less(input[j], input[i])){
                    swap(input, i, j);
                }
            }
        }
    }


    private static <T extends Comparable<T>> boolean less(T left, T right){
        return left.compareTo(right) == -1;
    }

    private static <T extends Comparable<T>> void swap(T[] input, int a, int b){
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}
