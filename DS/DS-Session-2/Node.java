package datastructure_2;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class Node {
    String element;
    Node linkNode;
    
    public Node(String element) {
        super();
        this.element = element;
    }

    /**
     * @return the element
     */
    public String getElement() {
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
