package com.symonjin;

import com.symonjin.collections.*;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new DynamicStack<>();

        for(int i = 0; i < 100; i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println("Stack: " + stack.top());
            stack.pop();
        }

    }
}
