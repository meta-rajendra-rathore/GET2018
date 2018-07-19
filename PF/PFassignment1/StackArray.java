import java.util.*;

class Implement{
	int[] array = new int[5];
	int top;
	
	public Implement(){
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public void push(int data){
		if(top==4)
			System.out.println("Stack Overflow!!!");
		else
			array[++top] = data;
	}
	
	public void pop(){
		if(isEmpty())
			System.out.println("List is empty, can not pop item.");
		else{
			int popped = array[top];
			top--;
			System.out.println("List is empty, can not pop item : " + popped);
		}
	}
	
	public void getTop(){
		if(isEmpty())
			System.out.println("List is empty hence no value on top!!!");
		else
			System.out.println("Top value is : " + array[top]);
	}
}

// main function to check the functioning of the implementation 

public class StackArray
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