package datastructure_1.queue_using_interface;

/**
 * The class implements queue using linked list
 * @author Rajendra Singh Rathore
 *
 */
import datastructure_1.Node;

public class QueueUsingLinkedList implements QueueInterface {
    Node front;
    Node rear;

    /**
     * this function remove one item from the queue from rear 
     * @return dequeuedData
     */
    @Override
    public int dequeue() {
        if (front == null) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int dequeuedDATA = front.getElement();
            front = front.getLinkNode();
            return dequeuedDATA;
        }
    }

    /**
     * this function enters one item in the queue from the front
     * 
     * @param element
     * @return true is successful otherwise false
     */
    @Override
    public boolean enqueue(int element) {
        Node node = new Node(element);
        if ((rear == null)) {
            front = node;
            rear = node;
        } else {
            rear.setLinkNode(node);
            rear = node;
        }
        return true;
    }

    /**
     * this function return the item at front
     * @return queueArray[front]
     */
    @Override
    public int peek() {
        if (front == null) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return front.getElement();
        }
    }
}
