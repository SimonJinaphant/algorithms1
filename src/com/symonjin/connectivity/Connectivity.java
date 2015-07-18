package com.symonjin.connectivity;

public abstract class Connectivity {

    int[] parents;

    public abstract void union(int p, int q);

    public abstract boolean find(int p, int q);

}
