package com.symonjin.algorithms;

public class Search {

    public static <T> int binarySearch(Comparable[] input, T key){

        int lowerBound = 0;
        int upperBound = input.length - 1;

        int middle, result;
        while(lowerBound <= upperBound){
            middle = lowerBound + (upperBound - lowerBound)/2;

            result = input[middle].compareTo(key);
            if(result > 0){
                upperBound = middle - 1;    //Currently larger than key
            }else if(result < 0){
                lowerBound = middle + 1;    //Currently smaller than key
            }else{
                return middle;
            }

        }

        return -1;
    }

}
