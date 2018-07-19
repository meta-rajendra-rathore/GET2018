import java.util.*;

class Node{
	Node link;
	int data;
	
	public Node(){
		link = null;
		data=0;
	}
	
	public Node(Node link, int data){
		this.link = link;
		this.data = data;
	}
	
	public Node getLink(){
		return link;
	}
	
	public int getData(){
		return data;
	}
	
	public void setLink(Node link){
		this.link = link;
	}
	
	public void setData(int data){
		this.data = data;
	}	
}

class Implement{
	Node top;
	
	public Implement(){
		top = null;
	}
	
	public boolean isEmpty(){
		return (top==null);
	}
	
	public void push(int data){
		Node newNode = new Node(top,data);
		top = newNode;
	}
	
	public void pop(){
		if(isEmpty())
			System.out.println("List is empty, can not pop item.");
		else{
			Node popNode = top;
			top = popNode.link;
			System.out.println("List is empty, can not pop item : " + popNode.getData());
		}
	}
	
	public void getTop(){
		if(isEmpty())
			System.out.println("List is empty hence no value on top!!!");
		else
			System.out.println("Top value is : " + top.data);
	}
}

// main function to check the functioning of the implementation 

public class StackImplement
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
        Implement node = new Implement();        
        char ch;     
        do 
        {
            System.out.println("STACK OPERATIONS\n");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. Top value");
            System.out.println("4. isEmpty");
			System.out.print("Enter Your choice : ");			
            int choice = scan.nextInt();
			
            switch (choice) 
            {
            case 1 :
                System.out.println("Enter element to push");
                node.push( scan.nextInt() ); 
                break;                         
            case 2 : 
                node.pop();
                break;                         
            case 3 : 
                node.getTop();
                break;                         
            case 4 : 
                System.out.println("List is empty : " + node.isEmpty());
                break; 
			default : 
                System.out.println("Wrong Entry \n ");
            }              
            System.out.println("\nDo you want to continue (y/n) : ");
            ch = scan.next().charAt(0);       
 
        } while (ch == 'Y'|| ch == 'y');                 
    }
}