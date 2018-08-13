package datastructure_6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplementUnidirectedWeightedGraphTest {
    ImplementUndirectedWeightedGraph graph;
    
    @Before
    public void init() {
        graph = new ImplementUndirectedWeightedGraph(5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 5, 9);
        graph.addEdge(3, 5, 6);
    }

    @Test
    public void test() {
        assertTrue(graph.isConnected()); 
    }

    @Test
    public void test1() {
        System.out.println(graph.mst()); 
    }

}
