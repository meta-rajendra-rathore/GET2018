package datastructure_6;

import java.util.List;

public interface UndirectedWeightedGraph<T> {
    
    public boolean isConnected();

    public List<T> reachableNodes(int a);

    public List<GraphEdge> mst();

    public int shotestPath(int a, int b); 

}
