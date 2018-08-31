package ds_Assignment_2.Q4_Counselling;

/**
 * @author Rajendra Singh Rathore
 *
 */
public interface Queue {

    public Student deQueue();
    public boolean enQueue(Student newStudent);
    public Student peek();
}
