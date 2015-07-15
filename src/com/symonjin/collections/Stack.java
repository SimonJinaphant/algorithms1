package com.symonjin.collections;

public abstract class Stack<T> {

    Node head;

    public abstract void push(T element);
    public abstract void pop();
    public abstract T top();
    public abstract int getSize();
    public abstract boolean isEmpty();

    protected class Node{
        T element;
        Node next;

        protected Node(T element){
            this.element = element;
        }
    }
}
