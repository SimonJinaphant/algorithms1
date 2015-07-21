package com.symonjin.collections;


/*
    An implementation of a Queue via a static array

    Maintaining the FIFO characteristic:
    We have a top pointer to "re-adjust" the array's starting point
 */
public class StaticQueue<T> extends Queue<T> {
    T[] elements;
    int size = 0;
    int headPointer = 0;

    public StaticQueue(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size >= elements.length) {
            System.err.println("Queue is already at max capacity");
            return;

        } else {
            //Insert the element at the tail of the array
            //If the tail is going out of bounds, wrap it around
            elements[(headPointer + size) % elements.length] = element;
            size++;
        }

    }

    @Override
    public T dequeue() {
        //Retrieve the data stored at the top since we're delete the node
        T data = elements[headPointer];

        /*
            Remove the top element and increment the top pointer;
            making the right adjacent element next for removal.

            If the increment goes out of bounds, make it wrap around
        */
        elements[headPointer] = null;
        headPointer = (headPointer + 1) % elements.length;
        size--;

        return data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
