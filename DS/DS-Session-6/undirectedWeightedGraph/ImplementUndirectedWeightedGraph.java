package datastructure_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ImplementUndirectedWeightedGraph implements UndirectedWeightedGraph<Integer> {
    final int NOOFNODES;
    List<GraphEdge> listOFEdges;

    public ImplementUndirectedWeightedGraph(int noOfNodes) {
        NOOFNODES = noOfNodes;
        listOFEdges = new ArrayList<>();
    }

    public boolean addEdge(int node1, int destination, int weight) {
        if (node1 > NOOFNODES || destination > NOOFNODES) {
            System.out.println("Source or destination is out of range!");
            return false;
        } else if (weight <= 0) {
            System.out.println("Weight should be greater than 0!");
            return false;
        }

        GraphEdge edge = new GraphEdge(node1, destination, weight);
        listOFEdges.add(edge);
        return true;
    }

    @Override
    public boolean isConnected() {
        Stack<Integer> stackDFS = new Stack<Integer>();
        boolean[] visitedNodeAsIndex = new boolean[NOOFNODES];
        visitNode(listOFEdges.get(0).getNode1(), stackDFS, visitedNodeAsIndex);
        for (int i = 0; i < visitedNodeAsIndex.length; i++) {
            if (!visitedNodeAsIndex[i]) {
                return false;
            }
        }
        return true;
    }

    private void visitNode(int node1, Stack<Integer> stackDFS, boolean[] visitedNodeAsIndex) {
        visitedNodeAsIndex[node1 - 1] = true;
        for (GraphEdge edge : listOFEdges) {
            if (edge.getNode1() == node1 && !visitedNodeAsIndex[edge.getNode2() - 1]) {
                stackDFS.push(edge.getNode2());
            } else if (edge.getNode2() == node1 && !visitedNodeAsIndex[edge.getNode1() - 1]) {
                stackDFS.push(edge.getNode1());
            }
        }
        if (!stackDFS.isEmpty()) {
            visitNode(stackDFS.pop(), stackDFS, visitedNodeAsIndex);
        }
    }

    @Override
    public List<Integer> reachableNodes(int node) {
        List<Integer> listOfReachableNodes = new ArrayList<>();
        for (GraphEdge edge : listOFEdges) {
            if ( node == edge.getNode1()) {
                listOfReachableNodes.add(edge.getNode2());
            } else if (node == edge.getNode2()) {
                listOfReachableNodes.add(edge.getNode1());
            } 
        }
        return listOfReachableNodes;
    }

    @Override
    public List<GraphEdge> mst() {
        int noOfVisitedNodes = 0;
        boolean[] visitedNodeAsIndex = new boolean[NOOFNODES];
        List<GraphEdge> listOfEdgesInMST = new ArrayList<>();
        Collections.sort(listOFEdges, new Comparator<GraphEdge>() {
            @Override
            public int compare(GraphEdge edge1, GraphEdge edge2) {
                return edge1.getWeight() - edge2.getWeight();
            }
        });
        
        for (GraphEdge edge : listOFEdges) {
            if (!(visitedNodeAsIndex[edge.getNode1() - 1] || visitedNodeAsIndex[edge.getNode1() - 1])) {
                listOfEdgesInMST.add(edge);
                visitedNodeAsIndex[edge.getNode1() - 1] = true;
                visitedNodeAsIndex[edge.getNode2() - 1] = true;
            }
        }
        
        if (noOfVisitedNodes != NOOFNODES) {
            return listOfEdgesInMST;
        }
        return listOfEdgesInMST;
    }

    @Override
    public int shotestPath(int a, int b) {
        
        return 0;
    }
}
