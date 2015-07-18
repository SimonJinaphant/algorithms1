package com.symonjin.collections;

public class StaticQueue<T> extends Queue<T> {

    T[] elements;
    int size = 0;
    int head = 0;

    public StaticQueue(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size >= elements.length) {
            System.err.println("Capacity reached, cannot enqueue");
            return;
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

        System.out.println("Dequeing " + data);
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
