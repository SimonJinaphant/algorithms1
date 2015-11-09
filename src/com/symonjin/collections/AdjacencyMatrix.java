package com.symonjin.collections;

import java.util.*;

/**
 * Created by Simon on 2015-11-07.
 */
public class AdjacencyMatrix implements Graph {

    private ArrayList<Vertex> ordering = new ArrayList<>();
    private ArrayList<BitSet> matrix;

    public void addVertex(Vertex v){
        ordering.add(v);
        for(BitSet row : matrix){
            row.set(ordering.size(), false);
        }
        matrix.add(new BitSet(ordering.size()));
    }

    public void addEdge(Vertex a, Vertex b){
        int aPosition = ordering.indexOf(a);
        int bPosition = ordering.indexOf(b);

        matrix.get(aPosition).set(bPosition, true);
    }

    public Set<Vertex> getVertices(){
        HashSet<Vertex> vertices = new HashSet<>();
        vertices.addAll(ordering);
        return vertices;
    }

}
