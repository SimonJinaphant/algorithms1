package com.symonjin.connectivity;

public class QuickFind extends Connectivity {

    public QuickFind(int capacity) {
        //Initially set each node to be its own parent
        parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        //Find the parent of each node and record them as it may get
        //overwritten when changing the parents later on
        int pOrigin = parents[p];
        int qOrigin = parents[q];

        if (pOrigin == qOrigin) return;

        //Change all nodes who's parent matches @p to @q's parent
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == pOrigin) {
                parents[i] = qOrigin;
            }
        }

    }

    @Override
    public boolean find(int p, int q) {
        //Two nodes are connected if they share the same parent
        return parents[p] == parents[q];
    }
}
