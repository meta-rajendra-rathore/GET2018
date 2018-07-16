import java.util.*;
class Item{													// Item class to construct product detail structure
	String name;
	int quantity;
	double price;
	
	public Item(String name, int quantity, double price){    // @params Product name, quantity and price
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	
	public String getName(){								// getter-setters
		return name;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
}

class ShoppingCart{											// ShoppingCart class to contain items
	HashMap<String,Item> cart = new HashMap<String,Item>();
	
	public void addItem(){									
		String name;
		int quantity;
		double price;
		
		System.out.print("Enter item's name : ");
		name = System.console().readLine();
		System.out.print("Enter item's price : ");
		price = Double.parseDouble(System.console().readLine());
		System.out.print("Enter quantity : ");
		quantity = Integer.parseInt(System.console().readLine());
		
		Item newItem = new Item(name,quantity,price);
		cart.put(name,newItem);
	}
	
	public void removeItem(){
		String name;
		System.out.print("Enter item's name to be removed : ");		// Inquiring which element is to be deleted 
		name = System.console().readLine();
		Item value = Item.class.cast(cart.get(name));				// casting object type output of HashMap get function to Item class
		if (value != null) {										// and then checking if product with the name entered exists or not
			System.out.println("Item successfully removed.");
			cart.remove(name);
		} else 
			System.out.println("Item not found!!!");
	}
	
	public void updateItem(){
		String name;
		int quantity;
		double price;
		
		System.out.print("Enter item's name to be updated : ");		// Inquiring which element is to be updated 
		name = System.console().readLine();
		
		Item value = Item.class.cast(cart.get(name));				// checking if product with the name entered exists or not
		if (value != null) {
			cart.remove(name);
			addItem();												// asking for new details
		} else 
			System.out.println("Item not found!!!");
	}
	
	public void showItems(){
		System.out.println("\nItem Details\n");
		for(Object obj : cart.values()){							// traversing the hashmap
			Item item = Item.class.cast(obj);
			System.out.println("Name : " +  item.getName());
			System.out.println("Price : " +  item.getPrice());
			System.out.println("Quantity : " +  item.getQuantity() + "\n");
		}
	}
	
	public void showBill(FixedOrderPromotion fixedOrderPromotion, FixedProductPromotion fixedProductPromotion){
		String userCode;
		Scanner scan = new Scanner(System.in);
		double totalBill=0.0;
		double totalDiscount=0.0;
		int totalQuantity=0;
		
		System.out.println("\n**************\n  Total bill\n**************");
		for(Object obj : cart.values()){
			Item item = Item.class.cast(obj);
			System.out.println(item.getName() + " : " + item.getQuantity() + "x" + item.getPrice());
			totalBill += item.getPrice()*item.getQuantity();		// finding total no of product and total amount in the bill
			totalQuantity += item.getQuantity();
		}
		
		System.out.println("Total amount : " + totalBill);
		System.out.print("Enter Promo code (Enter no if you don't have any) : ");
		userCode = scan.next();
		if(fixedOrderPromotion.isPromotionApplicable(totalBill,userCode))		// checking order amount based discount
			totalDiscount = fixedOrderPromotion.getFixedDiscount()*totalBill;
		else if(fixedProductPromotion.isPromotionApplicable(totalQuantity,totalBill,userCode))	// checking no of product & amount based discount
				totalDiscount = fixedProductPromotion.getFixedDiscount()*totalBill;
			
		System.out.println("Total discount applicable is : " + totalDiscount);
		System.out.println("\n************************\nFinal Payment : " +  (totalBill - totalDiscount) + "\n************************\n");
	}
}

public class Shopping{	
	public static void main(String[] args){
		ShoppingCart cart = new ShoppingCart();
		FixedOrderPromotion fixedOrderPromotion = new FixedOrderPromotion(5000.00);				// set the limits for discounts
		FixedProductPromotion fixedProductPromotion = new FixedProductPromotion(20,2000.00);	// on the two different bases
		char choice;
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("\nShopping Cart menu\n");
			System.out.println("1.Add an item");
			System.out.println("2.Remove an item");
			System.out.println("3.Update an item");
			System.out.println("4.Show all cart items");
			System.out.println("5.Show total bill");
			System.out.println("6.Exit");
			System.out.print("Enter Your choice : ");
			choice=scan.next().charAt(0);
			
			switch(choice){
				case '1' : 
					cart.addItem();
					break;
				case '2' :
					cart.removeItem();
					break;
				case '3' :
					cart.updateItem();
					break;
				case '4' :
					cart.showItems();
					break;
				case '5' :
					cart.showBill(fixedOrderPromotion, fixedProductPromotion);
					break;
				case '6' :
					System.exit(0);
				default :
					System.out.println("Wrong input!!! TRY AGAIN.");
			}
			
		}
	}
}