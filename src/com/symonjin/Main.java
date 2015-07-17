package com.symonjin;

import com.symonjin.collections.*;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new DynamicQueue<>();

        for(int i = 0; i < 100; i++){
            queue.enqueue(i);
        }

        while(!queue.isEmpty()){
            queue.dequeue();
        }


    }
}
