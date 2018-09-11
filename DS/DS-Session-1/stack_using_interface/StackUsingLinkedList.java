package datastructure_1.stack_using_interface;

/**
 * The class implements queue using linked list
 * @author Rajendra Singh Rathore
 *
 */

import datastructure_1.Node;

public class StackUsingLinkedList implements StackInterface {
    Node top;

    /**
     * this function remove one item from top of stack 
     * @return dequeuedData
     */
    @Override
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int poppedData = top.getElement();
            top = top.getLinkNode();
            return poppedData;
        }
    }

    /**
     * this function enters one item in the stack on top
     * 
     * @param element
     * @return true is successful otherwise false
     */
    @Override
    public boolean push(int element) {
        Node node = new Node(element);
        if (top == null) {
            top = node;
        } else {
            node.setLinkNode(top);
            top = node;
        }
        return true;
    }

    /**
     * this function return the item at top
     * @return top
     */
    @Override
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return top.getElement();
        }
    }
}
