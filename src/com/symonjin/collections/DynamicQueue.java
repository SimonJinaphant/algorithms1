package com.symonjin.collections;

import java.util.Arrays;

public class DynamicQueue<T> extends Queue<T> {

    T[] elements;
    int size = 0;
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
            System.out.println("Increasing size from " + size + " to " + size * 2);
            T[] newElements = Arrays.copyOf(elements, size * 2);
            elements = null;
            elements = newElements;

        } else {
            System.out.println("Enqueuing " + element);
            elements[(head + size) % elements.length] = element;
            size++;
        }

    }

    @Override
    public T dequeue() {
        T data = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;

        if (size <= elements.length / 4 && elements.length / 4 > 0) {
            System.out.print("Decreasing size from " + elements.length);
            T[] newElements = Arrays.copyOfRange(elements, head, head + size);
            elements = null;
            elements = newElements;
            System.out.print(" to " + elements.length + "\n");
            head = 0;
        }

        System.out.println("Dequeing " + data + " H:" + head + " S:" + size);
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
