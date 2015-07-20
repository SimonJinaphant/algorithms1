package com.symonjin.algorithms;

import com.symonjin.sorting.NLogNSort;

import java.util.Arrays;

public class Search {

    public static <T> int binarySearch(Comparable<T>[] input, T key) {

        int lowerBound = 0;
        int upperBound = input.length - 1;

        int middle, result;
        while (lowerBound <= upperBound) {
            middle = lowerBound + (upperBound - lowerBound) / 2;

            result = input[middle].compareTo(key);
            if (result > 0) {
                upperBound = middle - 1;    //Currently larger than key
            } else if (result < 0) {
                lowerBound = middle + 1;    //Currently smaller than key
            } else {
                return middle;
            }

        }

        return -1;
    }


    public static <T extends Comparable<? super T>> T quickSelect(T[] rawInput, int key){
        //Copy elements to preserve array's original order
        T[] input = Arrays.copyOf(rawInput, rawInput.length);

        int lower = 0, upper = input.length-1;
        while(upper > lower){
            int j = NLogNSort.partition(input, lower, upper);
            if(j < key){
                lower = j + 1;
            } else if(j > key){
                upper = j - 1;
            } else{
                return input[key];
            }
        }

        return input[key];
    }

}
