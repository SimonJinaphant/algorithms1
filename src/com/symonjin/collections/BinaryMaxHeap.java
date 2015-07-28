package com.symonjin.collections;

/**
 * An implementation of a Binary Heap, where the largest element
 * is always the top element in order to provide quick access and removal.
 * <p>
 * Inserts at log O(log N) time
 * Removes max element at O(log N) time
 * Gets the max element at O(1) time
 */
public class BinaryMaxHeap<T extends Comparable<? super T>> extends BinaryHeap<T> {


    /**
     * Determines if the left element is smaller than the right element
     */
    @Override
    protected boolean compare(int leftIndex, int rightIndex) {
        return elements[leftIndex].compareTo(elements[rightIndex]) == -1;
    }

}