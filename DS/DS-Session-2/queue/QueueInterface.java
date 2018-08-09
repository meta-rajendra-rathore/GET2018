package datastructure_2.queue;
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
