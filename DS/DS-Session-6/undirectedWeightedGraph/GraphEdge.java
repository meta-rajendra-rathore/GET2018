/**
 * 
 */
package datastructure_6;

/**
 * @author Rajendra Singh Rathore
 *
 */

public class GraphEdge {
    private int node1;
    private int node2;
    private int weight;
    
    public GraphEdge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getWeight() {
        return weight;
    }
    
    public String toString() {
        return "\n" + node1 + " <---> " + node2 + " : Weight = " + weight + "\n";
    }
}
