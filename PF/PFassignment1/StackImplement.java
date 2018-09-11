package get_assignment1;

import java.util.*;

class Node {
    Node link;
    int data;

    public Node() {
        link = null;
        data = 0;
    }

    public Node(Node link, int data) {
        this.link = link;
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public int getData() {
        return data;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class StackOperations {
    Node top;

    public StackOperations() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int data) {
        Node newNode = new Node(top, data);
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            Node popNode = top;
            top = popNode.link;
            return popNode.getData();
        }
    }

    public int getTop() {
        if (!isEmpty()) {
            return top.data;
        }
        return -1;

    }
}

// main function to check the functioning of the implementation 

public class StackImplement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackOperations node = new StackOperations();
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
                System.out.println("Enter element to push");
                node.push(scan.nextInt());
                break;
            case 2:
                if (node.pop() == -1)
                    System.out.println("List is empty, can not pop item.");
                else
                    System.out.println("Item popped out : " + node.pop());
                break;
            case 3:
                if (node.getTop() == -1)
                    System.out.println("List is empty hence no value on top!!!");
                else
                    System.out.println("Top value is : " + node.getTop());
                break;
            case 4:
                System.out.println("List is empty : " + node.isEmpty());
                break;
            case 5:
                scan.close();
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Entry \n ");
            }
        }
    }
}