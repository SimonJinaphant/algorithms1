package com.symonjin.collections;

public class LinkedStack<T> extends Stack<T> {

    Node top;
    int size = 0;

    @Override
    public void push(T data) {
        //Insert any new node at the @top in order to maintain FILO order
        if (isEmpty()) {
            top = new Node(data);
        } else {
            Node n = new Node(data);
            n.next = top;
            top = n;
        }

        size++;
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            //Reassign the @top element to the next node
            Node retrieved = top;
            top = retrieved.next;

            //Unlink the node we're about to pop from the new @top
            retrieved.next = null;
        }

        size--;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            System.err.println("Stack is empty");
            return null;
        } else {
            return top.element;
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

    protected class Node {
        T element;
        Node next;

        protected Node(T element) {
            this.element = element;
        }
    }

}
