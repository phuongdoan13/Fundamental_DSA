package A2_GraphTraverse;


import java.util.*;

class Graph {
    /*
        An implementation of unweighted, undirected graph;
    */
    Map<Integer, Map<Integer, Node>> graph;
    Map<Integer, Node> node_list;
    
    public Graph(){
        this.graph = new HashMap();
        this.node_list = new HashMap();
    }

    public void addNode(int key){
        // Add node into the graph
        if(!this.hasNode(key)){
            this.node_list.put(key, new Node(key));
            this.graph.put(key, new HashMap<Integer, Node>());
        }else{
            System.out.println("Node exists");
        }
    }

    public boolean hasNode(int key){
        // Check if a node with key exists
        return this.node_list.containsKey(key);
    }

    public void addEdge(int src, int dst){
        // Add edge into the graph
        if(!this.hasEdge(src, dst)){
            this.graph.get(src).put(dst, node_list.get(dst));
            this.graph.get(dst).put(src, node_list.get(src));
        }else{
            System.out.println("Edge exists");
        }
    }
    
    public boolean hasEdge(int src, int dst){
        // Check if an edge exists
        return this.hasNode(src) && this.hasNode(dst) && this.graph.get(src).containsKey(dst);
    }
}