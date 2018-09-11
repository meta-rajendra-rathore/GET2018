package datastructure_6;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    public void When_GraphConnected_Expect_True() {
        assertTrue(graph.isConnected());
    }

    @Test
    public void When_Vertex2Reachable_Expect_Vertex1Vertex3Vertex4() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(1, 3, 4)),
                graph.reachableNodes(2));
    }

    @Test
    public void when_GraphIsConnectedExpectMST() {
        ImplementUndirectedWeightedGraph expectedGraph = new ImplementUndirectedWeightedGraph(5);
        expectedGraph.addEdge(2, 3, 1);
        expectedGraph.addEdge(2, 4, 4);
        expectedGraph.addEdge(1, 2, 5);
        expectedGraph.addEdge(3, 5, 6);
        List<GraphEdge> expectedList = expectedGraph.listOFEdgesInGraph;
        assertEquals(expectedList, graph.mst()); 
    }

    @Test
    public void when_Vertex5IsReachableFrom1GetShortestPath() {
        assertEquals(12, graph.shortestPath(1, 5));
    }

    @Test
    public void when_VertexIsInvalid() {
        assertEquals(-1, graph.shortestPath(1, 6));
    }
}