package com.symonjin.connectivity;

public class QuickFind extends Connectivity {

    public QuickFind(int capacity) {
        parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pOrigin = parents[p];
        int qOrigin = parents[q];

        if (pOrigin == qOrigin) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == pOrigin) {
                parents[i] = qOrigin;
            }
        }

    }

    @Override
    public boolean find(int p, int q) {
        return parents[p] == parents[q];
    }
}
