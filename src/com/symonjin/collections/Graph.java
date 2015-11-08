package com.symonjin.collections;

import java.util.List;

/**
 * Created by Simon on 2015-11-07.
 */
public interface Graph {

    void addVertex(Vertex v);

    void addEdge(Vertex a, Vertex b);

    List<Vertex> getVertices();

}
