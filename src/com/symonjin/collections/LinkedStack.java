package com.symonjin.collections;

public class LinkedStack<T> extends Stack<T> {

    int size = 0;

    @Override
    public void push(T data){
        if(isEmpty()){
            head = new Node(data);
        }else{
            Node n = new Node(data);
            n.next = head;
            head = n;
        }

        size++;
    }

    @Override
    public void pop(){
        if(!isEmpty()){
            Node retrieved = head;
            head = retrieved.next;

            retrieved.next = null;
        }

        size--;
    }

    @Override
    public T top(){
        if(isEmpty()){
            System.err.println("Stack is empty");
            return null;
        }else{
            return head.element;
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int getSize(){
        return size;
    }



}
