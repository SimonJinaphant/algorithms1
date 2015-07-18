package com.symonjin;

import com.symonjin.algorithms.Search;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50,234,10,20,10,39,0};
        Arrays.sort(arr);

        for(Integer i : arr){
            System.out.print(i+", ");
        }
        System.out.println();


        System.out.println(Search.binarySearch(arr, 0));

    }
}
