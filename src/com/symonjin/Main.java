package com.symonjin;

import com.symonjin.connectivity.Connectivity;
import com.symonjin.connectivity.QuickUnionBySize;


public class Main {

    public static void main(String[] args) {

        Connectivity con = new QuickUnionBySize(5);
        con.union(1, 3);
        con.union(2, 3);

        if(con.find(1,2)){
            System.out.println("Connected");
        }else{
            System.out.println("nope");
        }

    }
}
