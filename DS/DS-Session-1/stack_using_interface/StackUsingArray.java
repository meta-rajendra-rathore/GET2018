package datastructure_1.stack_using_interface;

/**
 * The class implements stack using array
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class StackUsingArray implements StackInterface {
    int top;
    int[] stackArray;
    int MAX_SIZE;

    /**
     * @param max
     */
    public StackUsingArray(int max) {
        top = -1;
        MAX_SIZE = max;
        stackArray = new int[MAX_SIZE];
    }

    /**
     * this function remove one item from top of stack 
     * @return dequeuedData
     */
    @Override
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top--];
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
        if (++top == MAX_SIZE) {
            System.out.println("Stack overflow!");
            return false;
        } else {
            stackArray[top] = element;
            return true;
        }
    }

    /**
     * this function return the item at top
     * @return stackArray[top]
     */
    @Override
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

}
