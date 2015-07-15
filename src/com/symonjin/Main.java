package com.symonjin;

import com.symonjin.connectivity.Connectivity;
import com.symonjin.connectivity.QuickUnionBySize;
import com.symonjin.connectivity.QuickUnionByRank;
import com.symonjin.collections.LinkedStack;


public class Main {

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        for(int i = 0; i < 100; i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println("Stack: " + stack.top());
            stack.pop();
        }
    }
}
