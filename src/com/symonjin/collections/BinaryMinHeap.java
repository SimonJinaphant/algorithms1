package com.symonjin.collections;

/**
 * An implementation of a Binary Heap, where the smallest element
 * is always the top element in order to provide quick access and removal.
 * <p>
 * Inserts at log O(log N) time
 * Removes min element at O(log N) time
 * Gets the min element at O(1) time
 */
public class BinaryMinHeap<T extends Comparable<? super T>> extends BinaryHeap<T> {

    public BinaryMinHeap(int capacity) {
        super(capacity);
    }

    /**
     * Determines if the left element is greater than the right element
     */
    @Override
    protected boolean compare(int leftIndex, int rightIndex) {
        return elements[leftIndex].compareTo(elements[rightIndex]) == 1;
    }

}
