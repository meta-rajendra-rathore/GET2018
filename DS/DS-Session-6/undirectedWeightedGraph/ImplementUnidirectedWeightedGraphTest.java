package datastructure_6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplementUnidirectedWeightedGraphTest {
    ImplementUnidirectedWeightedGraph graph;
    
    @Before
    public void init() {
        graph = new ImplementUnidirectedWeightedGraph(5);
        graph.addEdge(1, 2, 5);
        //graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 5, 9);
        graph.addEdge(3, 5, 6);
    }

    @Test
    public void test() {
        assertTrue(graph.isConnected()); 
    }

}
