package datastructure_2;

/**
 * This interface provide structure definition and methods for stacks
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class StackImplementation {
    Node top;
    private int noOfItemsInStack;

    public String pop() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            String poppedData = top.getElement();
            top = top.getLinkNode();
            noOfItemsInStack--;
            return poppedData;
        }
    }

    public int getNoOfItemInStack() {
        return noOfItemsInStack;
    }

    /**
     * this function enters one item in the stack on top
     * 
     * @param element
     * @return true is successful otherwise false
     */

    public boolean push(String element) {
        Node node = new Node(element);
        if (top == null) {
            top = node;
        } else {
            node.setLinkNode(top);
            top = node;
        }
        noOfItemsInStack++;
        return true;
    }

    /**
     * this function return the item at top
     * 
     * @return top
     */
    public String peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return top.getElement();
        }
    }
}
