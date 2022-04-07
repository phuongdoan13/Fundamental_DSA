package A2_GraphTraverse;

public class GraphTraverse {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        g.addEdge(1,2);
        for(Integer key: g.graph.keySet()){
            System.out.println(key);
        }
    }
}
