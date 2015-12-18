package com.symonjin.collections.stack;


import java.util.Arrays;

public class DynamicStack<T> extends Stack<T> {

    T[] elements;
    int size = 0;

    public DynamicStack() {
        this(1);
    }

    public DynamicStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity, must be 1+");
        }
        this.elements = (T[]) new Object[capacity];

    }

    @Override
    public void push(T data) {
        if (size == elements.length) {
            //If the capacity is reached, double the capacity
            elements = Arrays.copyOf(elements, size * 2);
        }

        elements[size++] = data;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            return;
        }

        //Erase item at the end of the array
        elements[--size] = null;

        if (size <= elements.length / 4) {
            //System.out.print("Decreasing stack size from " + elements.length + " to "+ size);
            elements = Arrays.copyOf(elements, Math.max(size, 1));
        }
    }

    @Override
    public T top() {
        if (isEmpty()) {
            System.err.println("Stack is empty");
            return null;
        } else {
            return elements[size - 1];
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

}
