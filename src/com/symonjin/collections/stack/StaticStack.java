package com.symonjin.collections.stack;

import com.symonjin.collections.stack.Stack;

/**
 * An implementation of a Stack via a static array
 */
public class StaticStack<T> extends Stack<T> {

    T[] elements;

    //Keeps track of the current size, along with the index
    //of the next available spot in the stack
    int size = 0;

    public StaticStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    @Override
    public void push(T data) {
        if (size >= elements.length) {
            System.err.println("Stack is already at max capacity");
            return;
        }

        elements[size++] = data;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            System.err.println("Stack is empty, no element to pop");
            return;
        }

        elements[--size] = null;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            System.err.println("Stack is empty, no element to pop");
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
