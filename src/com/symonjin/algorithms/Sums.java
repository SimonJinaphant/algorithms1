package com.symonjin.algorithms;

import java.util.Arrays;

public class Sums {

    /*
        Goal: Given an array of numbers, find the amount of triples that add upto 0

        Solution: For every possible pair, use binary search to find
        the number than makes it add to 0.

     */
    public static int threeSumsProblem(Integer[] rawInput) {
        //Create a copy of the input to preserve its original order
        Integer[] input = Arrays.copyOf(rawInput, rawInput.length);

        //Sort the copy array to meet the pre-req of binary search
        Arrays.sort(input);

        int tripletCounter = 0;
        int result;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                result = Search.binarySearch(input, -(input[i] + input[j]));

                if (result >= 0 && result != i && result != j) {
                    //System.out.println(input[i] + " " + input[j]);
                    tripletCounter++;
                }
            }
        }

        return tripletCounter;
    }

}
