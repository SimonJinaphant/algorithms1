package com.symonjin.sorting;

public class Sort {

    public static <T extends Comparable<? super T>> int partition(
            T[] input, int lower, int upper){

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


    protected static <T extends Comparable<? super T>> boolean less(T left, T right) {
        return left.compareTo(right) == -1;
    }

    public static <T extends Comparable<? super T>> void swap(T[] input, int a, int b) {
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}
