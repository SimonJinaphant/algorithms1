package com.symonjin.algorithms;

import com.symonjin.sorting.Sort;

import java.util.Arrays;

public class Search {


    /*
        Goal: Find an element within a SORTED array

        Solution: Since the array is sorted in order, we can keep dividing the range
        into two halves to save comparisons.

    */
    public static <T extends Comparable<? super T>> int binarySearch(T[] input, T key) {

        int lowerBound = 0;
        int upperBound = input.length - 1;
        int middle, result;

        while (lowerBound <= upperBound) {
            middle = lowerBound + (upperBound - lowerBound) / 2;
            result = input[middle].compareTo(key);

            if (result > 0) {
                //Middle element is larger than the key
                //Reduce the upper bound for the next search
                upperBound = middle - 1;
            } else if (result < 0) {
                //Middle element is smaller than the key
                //Increase the lower bound for the next search
                lowerBound = middle + 1;
            } else {
                return middle;
            }

        }

        return -1;
    }


    /*
        Goal: Find the N'th smallest element within a given array

        Solution: Partition the array, but only focus on the necessary sub-array.
        This is very similar to sorting, but only sorts a certain range to find the
        smallest element.

     */
    public static <T extends Comparable<? super T>> T quickSelect(T[] rawInput, int N) {
        //Copy elements to preserve array's original order
        T[] input = Arrays.copyOf(rawInput, rawInput.length);

        int lowerBound = 0;
        int upperBound = input.length - 1;

        while (upperBound > lowerBound) {
            int pivot = Sort.partition(input, lowerBound, upperBound);

            //Adjust the range in a similar manner like binary search
            if (pivot < N) {
                lowerBound = pivot + 1;
            } else if (pivot > N) {
                upperBound = pivot - 1;
            } else {
                return input[N];
            }
        }

        return input[N];
    }

}
