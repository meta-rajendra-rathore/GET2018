package datastructure_1;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class Node {
    int element;
    Node linkNode;
    
    public Node(int element) {
        super();
        this.element = element;
    }

    /**
     * @return the element
     */
    public int getElement() {
        return element;
    }
    
    /**
     * @return the linkNode
     */
    public Node getLinkNode() {
        return linkNode;
    }

    /**
     * @param linkNode the linkNode to set
     */
    public void setLinkNode(Node linkNode) {
        this.linkNode = linkNode;
    }
 
    
}
