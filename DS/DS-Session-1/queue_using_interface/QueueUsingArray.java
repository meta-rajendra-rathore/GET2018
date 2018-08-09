package datastructure_1.queue_using_interface;

/**
 * The class implements queue using array
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class QueueUsingArray implements QueueInterface {
    int front;
    int rear;
    int[] queueArray;
    int MAX_SIZE;

    /**
     * Class constructor to initialize max size of the queue
     * @param max
     */
    public QueueUsingArray(int max) {
        front = -1;
        rear = 0;
        MAX_SIZE = max;
        queueArray = new int[MAX_SIZE];
    }

    /**
     * this function remove one item from the queue from rear 
     * @return dequeuedData
     */
    @Override
    public int dequeue() {
        if (front == -1 || front == rear) {
            System.out.println("Stack is empty! Can't remove item.");
            return -1;
        } else {
            int dequeuepedData = queueArray[front++];
            if (front == MAX_SIZE) {
                front = 0;
            }
            return dequeuepedData;
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
        if (front == rear) {
            System.out.println("Stack overflow! Can not add Element : " + element);
            return false;
        } else {
            if (front == -1)
                front = 0;
            queueArray[rear++] = element;
            if (rear == MAX_SIZE) {
                rear = 0;
            }
            return true;
        }
    }

    /**
     * this function return the item at front
     * @return queueArray[front]
     */
    @Override
    public int peek() {
        if (front == -1 || front == rear) {
            System.out.println("Stack is empty! Can't peek");
            return -1;
        } else {
            return queueArray[front];
        }
    }

}
