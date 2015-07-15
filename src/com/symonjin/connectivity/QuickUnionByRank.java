package com.symonjin.connectivity;

public class QuickUnionByRank extends Connectivity{

    private int[] rank;

    public QuickUnionByRank(int capacity){
        parents = new int[capacity];
        rank = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    @Override
    public void union(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if(pRoot == qRoot) return;

        if(rank[pRoot] > rank[qRoot]){
            parents[qRoot] = pRoot;
            rank[pRoot] += rank[qRoot];
        }else if (rank[pRoot] < rank[qRoot]){
            parents[pRoot] = qRoot;
            rank[qRoot] += rank[pRoot];
        }else{
            parents[pRoot] = qRoot;     //Arbitrary
            rank[qRoot]++;
        }
    }

    @Override
    public boolean find(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p){
        while(p != parents[p]){
            p = parents[parents[p]]; //Path halving
            p = parents[p];
        }

        return p;
    }
}
