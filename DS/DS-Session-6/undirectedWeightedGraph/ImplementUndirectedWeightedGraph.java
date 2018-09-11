package datastructure_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ImplementUndirectedWeightedGraph implements
        UndirectedWeightedGraph<Integer> {
    final int NO_OF_NODES;
    List<GraphEdge> listOFEdgesInGraph;

    public ImplementUndirectedWeightedGraph(int noOfNodes) {
        NO_OF_NODES = noOfNodes;
        listOFEdgesInGraph = new ArrayList<>();
    }

    public boolean addEdge(int node1, int destination, int weight) {
        if (node1 > NO_OF_NODES || destination > NO_OF_NODES) {
            System.out.println("Source or destination is out of range!");
            return false;
        } else if (weight <= 0) {
            System.out.println("Weight should be greater than 0!");
            return false;
        }

        GraphEdge edge = new GraphEdge(node1, destination, weight);
        listOFEdgesInGraph.add(edge);
        return true;
    }

    @Override
    public boolean isConnected() {
        Stack<Integer> stackDFS = new Stack<Integer>();
        boolean[] visitedNodeAsIndex = new boolean[NO_OF_NODES];
        visitNode(listOFEdgesInGraph.get(0).getNode1(), stackDFS,
                visitedNodeAsIndex);
        for (int i = 0; i < visitedNodeAsIndex.length; i++) {
            if (!visitedNodeAsIndex[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isConnected(List<GraphEdge> listOfEdges) {
        Stack<Integer> stackDFS = new Stack<Integer>();
        boolean[] visitedNodeAsIndex = new boolean[NO_OF_NODES];
        visitNode(listOfEdges.get(0).getNode1(), stackDFS, visitedNodeAsIndex);
        for (int i = 0; i < visitedNodeAsIndex.length; i++) {
            if (!visitedNodeAsIndex[i]) {
                return false;
            }
        }
        return true;
    }

    private void visitNode(int node1, Stack<Integer> stackDFS,
            boolean[] visitedNodeAsIndex) {
        visitedNodeAsIndex[node1 - 1] = true;
        for (GraphEdge edge : listOFEdgesInGraph) {
            if (edge.getNode1() == node1
                    && !visitedNodeAsIndex[edge.getNode2() - 1]) {
                stackDFS.push(edge.getNode2());
            } else if (edge.getNode2() == node1
                    && !visitedNodeAsIndex[edge.getNode1() - 1]) {
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
        for (GraphEdge edge : listOFEdgesInGraph) {
            if (node == edge.getNode1()) {
                listOfReachableNodes.add(edge.getNode2());
            } else if (node == edge.getNode2()) {
                listOfReachableNodes.add(edge.getNode1());
            }
        }
        return listOfReachableNodes;
    }

    @Override
    public List<GraphEdge> mst() {
        Set<Integer> checkVisitedNodes = new HashSet<Integer>();
        List<GraphEdge> listOfEdgesInMST = new ArrayList<>();

        Collections.sort(listOFEdgesInGraph, new Comparator<GraphEdge>() {
            @Override
            public int compare(GraphEdge edge1, GraphEdge edge2) {
                return edge1.getWeight() - edge2.getWeight();
            }
        });

        for (GraphEdge edge : listOFEdgesInGraph) {
            if (checkVisitedNodes.contains(edge.getNode1())
                    && checkVisitedNodes.contains(edge.getNode2())) {
                if (!isConnected(listOfEdgesInMST)) {
                    checkVisitedNodes.add(edge.getNode1());
                    checkVisitedNodes.add(edge.getNode2());
                }
            } else {
                listOfEdgesInMST.add(edge);
                checkVisitedNodes.add(edge.getNode1());
                checkVisitedNodes.add(edge.getNode2());
            }
        }

        return listOfEdgesInMST;
    }

    @Override
    public int shortestPath(int node1, int node2) {
        if (node1 > NO_OF_NODES || node1 < 0 || node2 > NO_OF_NODES || node2 < 1) {
            System.out.println("Invalid entry for nodes in shortestPath!");
            return -1;
        }
        
        int[][] graphMatrix = new int[NO_OF_NODES][NO_OF_NODES];
        int distanceOfVertices[] = new int[NO_OF_NODES];
        boolean vertexVisit[] = new boolean[NO_OF_NODES];
        
        for (GraphEdge edge : listOFEdgesInGraph) {
            graphMatrix[edge.getNode1()-1][edge.getNode2()-1] = edge.getWeight();
        }
        
        for (int i = 0; i < NO_OF_NODES; i++) {
            distanceOfVertices[i] = Integer.MAX_VALUE;
            vertexVisit[i] = false;
        }
        distanceOfVertices[node1-1] = 0;

        // Find Shortest path for all vertices
        for (int i = 0; i < NO_OF_NODES; i++) {
            
            int u = unvisitedNodeWithMinDistance(graphMatrix, distanceOfVertices, vertexVisit);
            vertexVisit[u] = true;

            // Updating Distance of the adjacent vertices of the selected
            // vertex.
            for (int v = 0; v < NO_OF_NODES; v++) {
                if (!vertexVisit[v] 
                        && graphMatrix[u][v] != 0
                        && distanceOfVertices[u] != Integer.MAX_VALUE
                        && distanceOfVertices[u] + graphMatrix[u][v] < distanceOfVertices[v]) {
                    
                    distanceOfVertices[v] = distanceOfVertices[u] + graphMatrix[u][v];
                }
            }
        }
        return distanceOfVertices[node2-1];
    }

    /**
     * Picks the Minimum Distance Vertex from the set of vertices not yet
     * visited.
     * 
     * @param distanceOfVertices
     * @param vertexVisit
     * @return
     */
    int unvisitedNodeWithMinDistance(int[][] graphMatrix, int distanceOfVertices[], boolean vertexVisit[]) {
        int minimumDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int v = 0; v < NO_OF_NODES; v++)
            if (vertexVisit[v] == false
                    && distanceOfVertices[v] <= minimumDistance) {
                minimumDistance = distanceOfVertices[v];
                index = v;
            }
        return index;
    }

    /*
     * @Override public List<Integer> shortestPath(int source, int destination)
     * { List<GraphEdge> shortestPathList = listOFEdgesInGraph; Map<Integer,
     * String> routeToNode = new HashMap<Integer, String>(); Map<Integer,
     * Integer> distanceToNode = new HashMap<Integer, Integer>(); Stack<Integer>
     * stackOfNodesVisited = new Stack();
     * 
     * routeToNode.put(source, source + ""); distanceToNode.put(source, 0);
     * 
     * traverseChild(stackOfNodesVisited, shortestPathList, routeToNode,
     * distanceToNode, destination);
     * 
     * return null; }
     * 
     * public void traverseChild(Stack<Integer> nodesVisited, List<GraphEdge>
     * shortestPathList, Map<Integer, String> routeToNode, Map<Integer, Integer>
     * distanceToNode, int destination) { if (!nodesVisited.isEmpty()) { if
     * (nodesVisited.peek() != destination) { int currentNode =
     * nodesVisited.pop(); for (GraphEdge edge : shortestPathList) { int
     * neighbourNode; if (currentNode == edge.getNode1()) { neighbourNode =
     * edge.getNode2(); } else if (currentNode == edge.getNode2()) {
     * neighbourNode = edge.getNode1(); } else { break; }
     * 
     * if (distanceToNode.containsKey(neighbourNode)) {
     * 
     * } } } } }
     */

}
