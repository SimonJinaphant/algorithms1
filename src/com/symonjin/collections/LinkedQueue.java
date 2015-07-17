package com.symonjin.collections;


public class LinkedQueue<T> extends Queue<T> {

    Node head, tail;
    int size;

    @Override
    public void enqueue(T element){
        System.out.println("Enqueuing: "+element);
        if(size == 0){
            head = new Node(element);
            tail = head;
        }else{
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue(){
        if(size == 0){
            System.err.println("Queue is already empty");
            return null;
        }

        T value = head.element;
        Node newHead = head.next;
        head = null;
        head = newHead;
        size--;

        System.out.println("Dequeuing "+value);

        return value;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    private class Node{
        T element;
        Node next;

        Node(T element){
            this.element = element;
        }
    }

}
