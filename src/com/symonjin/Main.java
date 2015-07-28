package com.symonjin;

import com.symonjin.collections.BinaryHeap;
import com.symonjin.collections.BinaryMaxHeap;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {50, 234, 10, 20, -30, 39, 2};
        BinaryHeap heap = new BinaryMaxHeap(arr.length);

        for (Integer i : arr) {
            heap.insert(i);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.top());
            heap.pop();
        }

    }
}
