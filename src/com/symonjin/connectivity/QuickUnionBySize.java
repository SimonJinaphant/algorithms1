package com.symonjin.connectivity;

public class QuickUnionBySize extends Connectivity {

    //Keeps track of the amount of child nodes + itself
    private int[] size;

    public QuickUnionBySize(int capacity) {
        //Initially set each node to be its own parent
        //and set each node's size to be 1 (itself)

        parents = new int[capacity];
        size = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        //Find the root of each node and record them
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        //Merge the smaller node size under the larger one
        //and update the larger node's size afterwards
        if (size[pRoot] > size[qRoot]) {
            parents[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parents[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
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

    private int findRootPC(int p){
        //Find the root via a recursive implementation, while re-ordering connections
        if (p != parents[p]) {
            //Path compression: all traversed nodes will point to root at the end
            parents[p] = findRootPC(p);
        }

        return p;
    }

}
