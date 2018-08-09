package datastructure_1.queue_using_interface;
/**
 * This interface provide structure definition and methods for stacks
 * 
 * @author Rajendra Singh Rathore
 *
 */
public interface QueueInterface {
    public int dequeue();

    public boolean enqueue(int element);

    public int peek();
}
