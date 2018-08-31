package datastructure_6;

import java.util.List;

public interface UnidirectedWeightedGraph<T> {
    
    public boolean isConnected();

    public List<Integer> reachable(int a);

    public int mst();

    public int shotestPath(int a, int b); 

}
