package com.symonjin.collections;

import java.util.Arrays;

public class DynamicQueue<T> extends Queue<T> {

    T[] elements;

    //Similar to the tail pointer, but can be used to keep track of the array's current size
    //The tail index is always (head+size)
    int size = 0;

    //The head pointer will change index when removing elements in order to maintain FIFO order
    int head = 0;

    public DynamicQueue() {
        this(1);
    }

    public DynamicQueue(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size >= elements.length) {
            //Double the capacity when the queue is completely full
            //System.out.println("Increasing size from " + size + " to " + size * 2);
            elements = Arrays.copyOf(elements, size * 2);

        } else {
            //Add new elements at the end of the queue, wrap around if necessary
            elements[(head + size) % elements.length] = element;
            size++;
        }

    }

    @Override
    public T dequeue() {
        //Remove elements at the @head and move the @head pointer one to the right
        //Wrap pointer around if it goes out of bounds
        T data = elements[head];
        elements[head] = null;

        head = (head + 1) % elements.length;
        size--;

        if (size <= elements.length / 4 && elements.length / 4 > 0) {
            //If the queue is only a quarter full, shrink the queue to match its current size
            //System.out.print("Decreasing size from " + elements.length + " to "+ size);
            elements = Arrays.copyOfRange(elements, head, head + size);

            //Reset the head pointer to the actual start (due to Array.copyRange)
            head = 0;
        }

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
