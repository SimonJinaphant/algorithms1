package com.symonjin.collections;


import java.util.Arrays;

public class DynamicStack<T> extends Stack<T> {

    T[] elements;
    int size = 0;

    public DynamicStack(){
        this(1);
    }

    public DynamicStack(int capacity){
        if(capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity, must be 1+");
        }
        this.elements = (T[]) new Object[capacity];

    }

    @Override
    public void push(T data){
        if(size == elements.length){
            System.out.print("Increasing stack size from " + elements.length);
            T[] newElements = Arrays.copyOf(elements, size*2);
            elements = newElements;
            System.out.print(" to " + elements.length + "\n");
        }

        elements[size++] = data;

    }

    @Override
    public void pop(){
        if(isEmpty()){
            System.err.println("Stack is empty...");
            return;
        }

        elements[--size] = null;

        if(size <= elements.length/4){
            System.out.print("Decreasing stack size from " + elements.length);
            T[] newElements = Arrays.copyOf(elements, Math.max(size, 1));
            elements = newElements;
            System.out.print(" to " + elements.length + "\n");
        }
    }

    @Override
    public T top(){
        if(isEmpty()){
            System.err.println("Stack is empty");
            return null;
        }else{
            return elements[size - 1];
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
