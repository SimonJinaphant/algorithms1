package com.symonjin.collections;

import java.util.Set;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Created by Simon on 2015-11-07.
 */
public class AdjacencyList implements Graph {

    HashMap<Vertex, LinkedList<Vertex>> adjList;

    public AdjacencyList(){
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v){
        adjList.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(Vertex a, Vertex b){
        if(!adjList.containsKey(a)){
            throw new RuntimeException("Vertex "+a+" does not exist in the graph");
        }
        adjList.get(a).add(b);
    }

    public Set<Vertex> getVertices(){
        return adjList.keySet();
    }


}
