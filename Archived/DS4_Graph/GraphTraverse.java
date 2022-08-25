package Archived.DS4_Graph;

public class GraphTraverse {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);

        for(Integer key: g.graph.keySet()){
            System.out.println(key);
        }
        
        System.out.println("Hello World");
        for(Integer key: g.DFS_iterative(1)){
            
            System.out.println(key);
        }
    }
}
