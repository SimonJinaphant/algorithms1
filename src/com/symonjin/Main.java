package com.symonjin;

import com.symonjin.sorting.NLogNSort;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50, 234, 10, -20, 10, 39, 2};
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        NLogNSort.quickSort(arr);
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
