package com.symonjin;

import com.symonjin.algorithms.*;
import com.symonjin.sorting.*;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50,234,10,-20,10,39,2};
        for(Integer i : arr){
            System.out.print(i + ", ");
        }
        System.out.println();

        NSort.bubbleSort(arr);
        for(Integer i : arr){
            System.out.print(i + ", ");
        }
        System.out.println();

        //System.out.println(Sums.threeSumsProblem(arr));

    }
}
