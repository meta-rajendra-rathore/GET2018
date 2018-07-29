package get_assignment1;

import java.util.*;

class Implement {
    int[] array;
    int MAX_SIZE;
    int top;

    public Implement(int max) {
        MAX_SIZE = max;
        array = new int[MAX_SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(int data) {
        if (top == (MAX_SIZE - 1))
            System.out.println("Stack Overflow!!!");
        else
            array[++top] = data;
    }

    public int pop() {
        if (!isEmpty()) {
            int popped = array[top];
            top--;
            return popped;
        }
        return -1;
    }

    public int getTop() {
        if (!isEmpty())
            return array[top];
        return -1;
    }
}

// main function to check the functioning of the implementation 

public class StackArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter stack size : ");
        int size = scan.nextInt();
        Implement node = new Implement(size);
        while (true) {
            System.out.println("STACK OPERATIONS\n");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. Top value");
            System.out.println("4. isEmpty");
            System.out.println("5. Exit");
            System.out.print("Enter Your choice : ");
            int choice = scan.nextInt();

            switch (choice) {
            case 1:
                System.out.print("Enter element to push : ");
                node.push(scan.nextInt());
                break;
            case 2:
                if (node.pop() == -1)
                    System.out.println("List is empty, can not pop item");
                else
                    System.out.println("Item popped out : " + node.pop());
                break;
            case 3:
                if (node.getTop() == -1)
                    System.out.println("List is empty, Nothing on top!!!");
                else
                    System.out.println("Top value is : " + node.getTop());
                break;
            case 4:
                System.out.println("List is empty : " + node.isEmpty());
                break;
            case 5:
                scan.close();
                System.exit(0);
            default:
                System.out.println("Wrong Entry \n ");
            }
        }
    }
}