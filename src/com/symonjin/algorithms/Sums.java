package com.symonjin.algorithms;

import java.util.Arrays;

public class Sums {

    public static int threeSumsProblem(Integer[] input){
        Arrays.sort(input);
        int counter = 0;
        int result;
        for(int i = 0; i < input.length; i++){
            for (int j = i+1; j < input.length; j++){
                result = Search.binarySearch(input, -(input[i] + input[j]));
                if(result >= 0 && result != i && result != j){
                    System.out.println(input[i]+" "+input[j]);
                    counter++;
                }
            }
        }

        return counter;
    }

}
