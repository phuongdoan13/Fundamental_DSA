package A2_GraphTraverse;

import java.util.*;


public class Edge {
    /*
        Implementation of edge
    */
    Node src;
    Node dst;
    int weight;
    
    public Edge(Node src, Node dst){
        this.src = src;
        this.dst = dst;
    }

    public Edge(Node src, Node dst, int weight){
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }
}
