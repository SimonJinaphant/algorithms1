package com.symonjin.connectivity;

public class QuickUnionBySize extends Connectivity {

    private int[] size;

    public QuickUnionBySize(int capacity) {
        parents = new int[capacity];
        size = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

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
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        while (p != parents[p]) {
            p = parents[parents[p]]; //Path halving
            p = parents[p];
        }

        return p;
    }

    private int findRootPC(int p) {
        if (p != parents[p]) {
            //Path compression: all nodes point to root in the end
            parents[p] = findRootPC(p);
        }

        return p;
    }

}
