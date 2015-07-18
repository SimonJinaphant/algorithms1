package com.symonjin.collections;

public abstract class Queue<T> {

    public abstract void enqueue(T element);

    public abstract T dequeue();

    public abstract int getSize();

    public abstract boolean isEmpty();

}
