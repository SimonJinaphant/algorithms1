package com.symonjin.collections;

public abstract class Stack<T> {

    public abstract void push(T element);
    public abstract void pop();
    public abstract T top();
    public abstract int getSize();
    public abstract boolean isEmpty();


}
