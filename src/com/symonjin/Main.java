package com.symonjin;

import com.symonjin.collections.BinaryMinHeap;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50, 234, 10, 20, -30, 39, 2};
        BinaryMinHeap heap = new BinaryMinHeap(arr.length);

        for (Integer i : arr) {
            heap.insert(i);
        }

        while (!heap.isEmpty()){
            System.out.println(heap.getMinElement());
            heap.removeMin();
        }
        
    }
}
