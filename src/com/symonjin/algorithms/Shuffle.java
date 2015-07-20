package com.symonjin.algorithms;


import java.util.Random;
import com.symonjin.sorting.Sort;

public class Shuffle {

    public static <T extends Comparable<? super T>> void shuffle(T[] input){
        Random rand = new Random();

        for(int i = 0; i < input.length; i++){
            int r = rand.nextInt(i+1);
            Sort.swap(input, i, r);
        }

    }
}
