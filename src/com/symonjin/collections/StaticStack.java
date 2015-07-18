package com.symonjin.collections;


public class StaticStack<T> extends Stack<T> {

    T[] elements;
    int size = 0;

    public StaticStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    @Override
    public void push(T data) {
        if (size >= elements.length) {
            System.err.println("Stack at max capacity");
            return;
        }

        elements[size++] = data;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            System.err.println("Stack is empty...");
            return;
        }

        elements[--size] = null;
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
