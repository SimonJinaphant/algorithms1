package com.symonjin.collections;

import java.util.*;

/**
 * Created by Simon on 2015-11-07.
 */
public class AdjacencyMatrix implements Graph {

    private ArrayList<Vertex> ordering = new ArrayList<>();
    private ArrayList<BitSet> matrix = new ArrayList<>();

    public void addVertex(Vertex v){
        if(!ordering.contains(v)){
            ordering.add(v);
            for(BitSet row : matrix){
                row.set(ordering.size(), false);
            }
            matrix.add(new BitSet(ordering.size()));
        }
    }

    public void addEdge(Vertex a, Vertex b){
        int aPosition = getOrdering(a);
        int bPosition = getOrdering(b);

        matrix.get(aPosition).set(bPosition, true);
    }

    public boolean hasEdge(Vertex a, Vertex b){
        int aPosition = getOrdering(a);
        int bPosition = getOrdering(b);

        return matrix.get(aPosition).get(bPosition);
    }

    public Set<Vertex> getVertices(){
        HashSet<Vertex> vertices = new HashSet<>();
        vertices.addAll(ordering);
        return vertices;
    }

    private int getOrdering(Vertex v){
        int position = ordering.indexOf(v);
        if(position < 0){
            throw new RuntimeException("Vertex " + v + " does not exist in this graph");
        }
        return position;
    }

}
