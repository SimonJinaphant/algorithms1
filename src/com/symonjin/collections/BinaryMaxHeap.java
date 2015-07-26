package com.symonjin.collections;

/**
 * An implementation of a Binary Heap, where the largest element
 * is always the top element in order to provide quick access and removal.
 */
public class BinaryMaxHeap<T extends Comparable<? super T>> {

    T[] elements;
    int size;


    /**
     * Construct the BinaryMaxHeap with a given initial capacity
     * The max element will be located at index 1 to simplify index arithmetic
     *
     * @param capacity The initial size of the max heap
     */
    public BinaryMaxHeap(int capacity){
        elements = (T[]) new Comparable[capacity + 1];
        size = 0;
    }


    /**
     * Tests if the heap is currently empty
     *
     * @return a flag indicating whether the heap is empty or not
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * Inserts an element into the heap and reorder the heap
     * if necessary, in order to maintain max-heap order
     *
     * @param element The element to be inserted into the heap
     */
    public void insert(T element){
        elements[++size] = element;
        swim(size);
    }


    /**
     * Removes the max element currently located at the top of the heap
     * and reorder the heap if necessary, to maintain max-heap order
     *
     * @return The max element on the heap
     */
    public T removeMax(){
        //Swap the max node with a leaf node and sink the leaf downwards
        T max = elements[1];
        swap(1, size--);        //Make sure size decreases to avoid confusion
        sink(1);

        //Remove reference to the max element secretly stored at the old @size position
        elements[size+1] = null;
        return max;
    }


    /**
     * Starting at a given node, iterate upward to the root of the heap
     * If the parent node (index/2) is smaller than its child (index), swap it
     *
     * @param index The starting index to test for max-heap invariants
     */
    private void swim(int index){
        while (index > 1 && less(index/2, index)){
            swap(index/2, index);
            index /= 2;
        }
    }


    /**
     * Starting at a given node, iterate downwards to the leaf nodes of the heap
     * If the smallest of the two child node is larger than the
     * current (parent) node, swap it.
     *
     * @param index The starting index to test for max-heap invariants
     */
    private void sink(int index){

        //If the node has a child, re-adjust the heap to maintain order
        while(index * 2 <= size){

            int childIndex = 2 * index;
            if(childIndex < size && less(childIndex, childIndex+1)){
                //Right child is larger than the left child, making it ideal to swap with
                childIndex++;
            }

            if(!less(index, childIndex)){
                //Heap is already in order
                break;
            }

            swap(index, childIndex);
            index = childIndex;
        }
    }


    /**
     * Determines if the left element is smaller than the right element
     */
    private boolean less(int leftIndex, int rightIndex) {
        return elements[leftIndex].compareTo(elements[rightIndex]) == -1;
    }


    /**
     * Swaps the elements at the specified indices
     */
    private void swap(int a, int b) {
        T temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }

}
