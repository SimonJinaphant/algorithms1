package com.symonjin.algorithms;

import com.symonjin.sorting.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Search {


    /**
     * Goal: Efficiently find an element within a SORTED array
     * <p>
     * Solution: Since the array is sorted in order, we can keep dividing
     * the range into two halves to reduce the search
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


    /**
     * Goal: Find the N'th smallest element within a given array,
     * make sure it is scalable to work with absurdly large input sizes.
     * <p>
     * Solution: Partition the array, but only focus on the necessary sub-array.
     * This is very similar to sorting, but only sorts a certain range to find the
     * smallest element.
     */
    public static <T extends Comparable<? super T>> T quickSelect(T[] rawInput, int N) {
        //Copy elements to preserve array's original order
        T[] input = Arrays.copyOf(rawInput, rawInput.length);

        int lowerBound = 0;
        int upperBound = input.length - 1;

        while (upperBound > lowerBound) {
            int pivotIndex = Sort.partition(input, lowerBound, upperBound);

            //Adjust the range in a similar manner like binary search
            if (pivotIndex < N) {
                //N'th smallest is to the right of the pivot, increase the lower bound
                lowerBound = pivotIndex + 1;
            } else if (pivotIndex > N) {
                //N'th smallest is to the left of the pivot, decrease the upper bound
                upperBound = pivotIndex - 1;
            } else {
                return input[N];
            }
        }

        return input[N];
    }

    /**
     * Goal: Find the largest M items in a stream of N items (N is too large to completely store)
     * <p>
     * Solution: Implement a min-heap of M capacity, add items one-by-one and keep
     * removing the smallest when the capacity is reached.
     */
    public static <T extends Comparable<? super T>> void largestElements(T[] input, int M) {
        PriorityQueue<T> minHeap = new PriorityQueue<>(M);

        for (T element : input) {
            minHeap.add(element);
            if (minHeap.size() > M) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

    }

}
