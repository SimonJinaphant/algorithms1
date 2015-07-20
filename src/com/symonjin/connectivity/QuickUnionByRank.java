package com.symonjin.connectivity;

public class QuickUnionByRank extends Connectivity {

    //Keeps track of each node's rank (rank is similar to, but not actually, the tree-height)
    private int[] rank;

    public QuickUnionByRank(int capacity) {
        //Initially set each node to be its own parent
        //and set each node's rank to 0 (Has no depth)

        parents = new int[capacity];
        rank = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        //Find the root of each node and record them
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        //Merge the smaller node under the larger one
        //and update the larger node's size afterwards
        if (rank[pRoot] > rank[qRoot]) {
            parents[qRoot] = pRoot;
            rank[pRoot] += rank[qRoot];
        } else if (rank[pRoot] < rank[qRoot]) {
            parents[pRoot] = qRoot;
            rank[qRoot] += rank[pRoot];
        } else {
            //If they are both the same size, arbitrary choose one and increment its rank
            parents[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }

    @Override
    public boolean find(int p, int q) {
        //Two nodes are connected if they share the same parent
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p){
        return findRoot(p, true);
    }

    private int findRoot(int p, boolean pathHalving) {
        //Iteratively find the root node
        while (p != parents[p]) {

            if(pathHalving){
                //Reduce intermediate connections by making each
                //iterated node point to its grandparent (Optional)
                p = parents[parents[p]];
            }

            p = parents[p];
        }

        return p;
    }
}
