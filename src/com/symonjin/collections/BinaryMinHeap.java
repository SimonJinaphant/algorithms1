package com.symonjin.collections;

/**
 * An implementation of a Binary Heap, where the smallest element
 * is always the top element in order to provide quick access and removal.
 *
 * Inserts at log O(log N) time
 * Removes min element at O(log N) time
 * Gets the min element at O(1) time
 *
 */
public class BinaryMinHeap<T extends Comparable<? super T>> {

    T[] elements;
    int size;


    /**
     * Construct the BinaryMinHeap with a given initial capacity
     * The min element will be located at index 1 to simplify index arithmetic
     *
     * @param capacity The initial size of the min heap
     */
    public BinaryMinHeap(int capacity){
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
     * if necessary, in order to maintain min-heap order
     *
     * @param element The element to be inserted into the heap
     */
    public void insert(T element){
        elements[++size] = element;
        swim(size);
    }


    /**
     * Removes the min element currently located at the top of the heap
     * and reorder the heap if necessary, to maintain min-heap order
     *
     */
    public void removeMin(){
        //Swap the min node with a leaf node and sink the leaf downwards
        swap(1, size--);        //Make sure size decreases to avoid confusion
        sink(1);

        //Remove reference to the min element secretly stored at the old @size position
        elements[size+1] = null;
    }

    /**
     * Gets the value of the min element
     * @return The min element on the heap
     */

    public T getMinElement(){
        return elements[1];
    }


    /**
     * Starting at a given node, iterate upward to the root of the heap
     * If the parent node (index/2) is smaller than its child (index), swap it
     *
     * @param index The starting index to test for min-heap invariants
     */
    private void swim(int index){
        while (index > 1 && greater(index/2, index)){
            swap(index/2, index);
            index /= 2;
        }
    }


    /**
     * Starting at a given node, iterate downwards to the leaf nodes of the heap
     * If the smallest of the two child node is larger than the
     * current (parent) node, swap it.
     *
     * @param index The starting index to test for min-heap invariants
     */
    private void sink(int index){

        //If the node has a child, re-adjust the heap to maintain order
        while(index * 2 <= size){

            int childIndex = 2 * index;
            if(childIndex < size && greater(childIndex, childIndex+1)){
                //Right child is smaller than the left child, making it ideal to swap with
                childIndex++;
            }

            if(!greater(index, childIndex)){
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
    private boolean greater(int leftIndex, int rightIndex) {
        return elements[leftIndex].compareTo(elements[rightIndex]) == 1;
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
