package com.symonjin;

import com.symonjin.collections.Stack;
import com.symonjin.collections.StaticStack;


public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new StaticStack<>(100);

        for(int i = 0; i < 100; i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println("Stack: " + stack.top());
            stack.pop();
        }
    }
}
