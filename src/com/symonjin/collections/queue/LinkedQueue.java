package com.symonjin.collections.queue;


public class LinkedQueue<T> extends Queue<T> {

    //Maintain two pointers at both end linked list respectively
    Node head, tail;
    int size;

    @Override
    public void enqueue(T element) {
        //Insert any new element at the @tail, unless the linked list is empty
        if (size == 0) {
            head = new Node(element);
            tail = head;
        } else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            System.err.println("Queue is already empty");
            return null;
        }

        //Remove any element at the @head by reassigning the @head pointer to the
        //next element and unlink the old @head from the new @head
        Node n = head;
        head = n.next;
        n.next = null;

        size--;

        return n.element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        T element;
        Node next;

        Node(T element) {
            this.element = element;
        }
    }

}
