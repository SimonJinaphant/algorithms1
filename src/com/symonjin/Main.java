package com.symonjin;

import com.symonjin.connectivity.QuickFind;

public class Main {

    public static void main(String[] args) {

        QuickFind qf = new QuickFind(5);
        qf.union(1,3);
        qf.union(2,3);

        if(qf.find(1,2)){
            System.out.println("Connected");
        }else{
            System.out.println("nope");
        }

    }
}
