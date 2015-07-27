package com.symonjin.collections;

import java.util.Comparator;

public abstract class BinaryHeap<T extends Comparable<? super T>> {

    T[] elements;
    int size;
    Comparator<T> comparator;

    /**
     * Construct the BinaryHeap with a given initial capacity
     * The chosen element will be located at index 1 to simplify index arithmetic
     *
     * @param capacity The initial size of the heap
     */
    public BinaryHeap(int capacity, Comparator<T> comparator){
        elements = (T[]) new Comparable[capacity + 1];
        size = 0;
        this.comparator = comparator;
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
     * if necessary, in order to maintain heap order
     *
     * @param element The element to be inserted into the heap
     */
    public void insert(T element){
        elements[++size] = element;
        swim(size);
    }


    /**
     * Removes the chosen element currently located at the top of the heap
     * and reorder the heap if necessary, to maintain heap order
     *
     */
    public void pop(){
        //Swap the max node with a leaf node and sink the leaf downwards
        swap(1, size--);        //Make sure size decreases to avoid confusion
        sink(1);

        //Remove reference to the max element secretly stored at the old @size position
        elements[size+1] = null;
    }

    /**
     * Gets the value of the chosen element
     * @return The chosen element on the heap
     */

    public T getMaxElement(){
        return elements[1];
    }


    /**
     * Starting at a given node, iterate upward to the root of the heap
     * If the parent node (index/2) creates an invariant with its child (index): swap it
     *
     * @param index The starting index to test for heap invariants
     */
    private void swim(int index){
        while (index > 1 && less(index/2, index)){
            swap(index/2, index);
            index /= 2;
        }
    }


    /**
     * Starting at a given node, iterate downward to the leaf nodes of the heap
     * If there is an invariant in the heap order: swap it.
     *
     * @param index The starting index to test for heap invariants
     */
    protected void sink(int index){

        //If the node has a child, re-adjust the heap to maintain order
        while(index * 2 <= size){

            int childIndex = 2 * index;
            if(childIndex < size && less(childIndex, childIndex+1)){
                //Right child has higher priority than the left child, making it ideal to swap with
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


    private boolean less(int leftIndex, int rightIndex){
        return comparator.compare(elements[leftIndex], elements[rightIndex]) == -1;
    }

    /**
     * Swaps the elements at the specified indices
     */
    protected void swap(int a, int b) {
        T temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
