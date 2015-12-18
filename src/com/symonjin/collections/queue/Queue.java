package com.symonjin.collections.queue;

public abstract class Queue<T> {

    public abstract void enqueue(T element);

    public abstract T dequeue();

    public abstract int getSize();

    public abstract boolean isEmpty();

}
