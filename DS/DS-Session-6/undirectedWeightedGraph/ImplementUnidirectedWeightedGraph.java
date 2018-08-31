package datastructure_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ImplementUnidirectedWeightedGraph implements UnidirectedWeightedGraph<Integer> {
    final int NOOFNODES;
    List<GraphEdge> listOFEdges;

    public ImplementUnidirectedWeightedGraph(int noOfNodes) {
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
        boolean[] visitedNodeIndexVise = new boolean[NOOFNODES];
        visitNode(listOFEdges.get(0).getNode1(), stackDFS, visitedNodeIndexVise);
        for (int i = 0; i < visitedNodeIndexVise.length; i++) {
            if (!visitedNodeIndexVise[i]) {
                return false;
            }
        }
        return true;
    }

    private void visitNode(int node1, Stack<Integer> stackDFS, boolean[] visitedNodeIndexVise) {
        visitedNodeIndexVise[node1 - 1] = true;
        for (GraphEdge edge : listOFEdges) {
            if (edge.getNode1() == node1 && !visitedNodeIndexVise[edge.getNode2() - 1]) {
                stackDFS.push(edge.getNode2());
            } else if (edge.getNode2() == node1 && !visitedNodeIndexVise[edge.getNode1() - 1]) {
                stackDFS.push(edge.getNode1());
            }
        }
        if (!stackDFS.isEmpty()) {
            visitNode(stackDFS.pop(), stackDFS, visitedNodeIndexVise);
        }
    }

    @Override
    public List<Integer> reachable(int a) {

        return null;
    }

    @Override
    public int mst() {
        Collections.sort(listOFEdges, new Comparator<GraphEdge>() {
            @Override
            public int compare(GraphEdge edge1, GraphEdge edge2) {
                return edge1.getWeight() - edge2.getWeight();
            }
        });
        return 0;
    }

    @Override
    public int shotestPath(int a, int b) {
        // TODO Auto-generated method stub
        return 0;
    }
}
