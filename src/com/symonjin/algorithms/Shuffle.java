package com.symonjin.algorithms;

import com.symonjin.sorting.Sort;

import java.util.Random;

public class Shuffle {


    /**
     * Goal: Randomly shuffle an array within O(N) time
     *
     * Solution: Iterate through the array, for every iteration i: randomly
     * generate a number r between [0, i] or [i, N) and swap the elements
     * at position i and r.
     */
    public static <T extends Comparable<? super T>> void shuffle(T[] input) {
        Random rand = new Random();

        for (int i = 0; i < input.length; i++) {
            int r = rand.nextInt(i + 1);
            Sort.swap(input, i, r);
        }

    }
}
