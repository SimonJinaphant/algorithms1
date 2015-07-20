package com.symonjin;

import com.symonjin.algorithms.Search;
import com.symonjin.algorithms.Shuffle;
import com.symonjin.algorithms.Sums;
import com.symonjin.sorting.NLogNSort;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50, 234, 10, 20, -30, 39, 2};
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println(Sums.threeSumsProblem(arr));
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
