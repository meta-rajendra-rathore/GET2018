package shopping;

import java.util.*;
class Item {													// Item class to construct product detail structure
	String name;
	int quantity;
	double price;
	int promotionDiscount;
	
	public Item(String name, int quantity, double price, int promotionDiscount) {    // @params Product name, quantity and price
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.promotionDiscount = promotionDiscount;
	}
	
	public String getName() {								// getter-setters
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getPromotionDiscount() {
		return promotionDiscount;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

class ShoppingCart {											// ShoppingCart class to contain items
	HashMap <String, Item> cart = new HashMap <String, Item>();
	
	public void addItem(String name, int quantity, double price, int promotion) {			
		Item newItem = new Item(name, quantity, price, promotion);
		cart.put(name, newItem);
	}
	
	public void removeItem(String name) {
		Item value = Item.class.cast(cart.get(name));				// casting object type output of HashMap get function to Item class
		if (value != null) {										// and then checking if product with the name entered exists or not
			System.out.println("Item successfully removed.");
			cart.remove(name);
		} else 
			System.out.println("Item not found!!!");
	}
	
	public void updateItem(String name, int newQuantity) {		
		Item value = Item.class.cast(cart.get(name));				// checking if product with the name entered exists or not
		if (value != null) {
			value.setQuantity(newQuantity);
			cart.put(name, value);											
		} else 
			System.out.println("Item not found!!!");
	}
	
	public void showItems() {
		System.out.println("\n**************\n  Item Details\n**************\n");
		for (Object obj : cart.values()) {							// traversing the hashmap
			Item item = Item.class.cast(obj);
			System.out.println("Name : " +  item.getName());
			System.out.println("Price : " +  item.getPrice());
			System.out.println("Quantity : " +  item.getQuantity() + "\n");
		}
		
		System.out.println("That's all you got in the cart.");
	}
	
	public void showBill(FixedOrderPromotion fixedOrderPromotion, FixedProductPromotion fixedProductPromotion, String userCode) {
		double totalBill=0.0;
		double totalDiscount=0.0;
		int totalQuantity=0;
		
		System.out.println("\n**************\n  Total bill\n**************");
		for (Object obj : cart.values()) {
			Item item = Item.class.cast(obj);
			System.out.println(item.getName() + " : " + item.getQuantity() + "x" + item.getPrice());
			totalBill += item.getPrice() * item.getQuantity();		// finding total no of product and total amount in the bill
			totalQuantity += item.getQuantity();
			totalDiscount += item.getPrice() * item.getQuantity() * item.getPromotionDiscount() / 100;
		}
		
		System.out.println("Total amount : " + totalBill);
		
		if (userCode.equals("no") || userCode.equals("NO"))
			return;
		if (!fixedProductPromotion.isPromotionApplicable(totalQuantity, totalBill, userCode)) {	// checking no of product & amount based discount
			totalDiscount = 0;
		} else if (fixedOrderPromotion.isPromotionApplicable(totalQuantity, (totalBill - totalDiscount), userCode)) {		// checking order amount based discount
			totalDiscount += fixedOrderPromotion.getFixedDiscount() * (totalBill - totalDiscount) / 100;
		}
		
		System.out.println("Total discount applicable is : " + totalDiscount);
		System.out.println("\n************************\nFinal Payment : " +  (totalBill - totalDiscount) + "\n************************\n");
	}
}

public class Shopping {	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		FixedOrderPromotion fixedOrderPromotion = new FixedOrderPromotion(5000.00, 5);				// set the limits for discounts
		FixedProductPromotion fixedProductPromotion = new FixedProductPromotion(2000.00, 5);	// on the two different bases
		char choice;
		String name;
		int quantity;
		double price;
		int promotionDiscount;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nShopping Cart menu\n");
			System.out.println("1.Add an item");
			System.out.println("2.Remove an item");
			System.out.println("3.Update an item");
			System.out.println("4.Show all cart items");
			System.out.println("5.Show total bill");
			System.out.println("6.Exit");
			System.out.print("Enter Your choice : ");
			choice=scan.next().charAt(0);
			
			switch (choice) {
				case '1' :
					System.out.print("Enter item's name : ");
					name = scan.next();
					System.out.print("Enter item's price : ");
					price = scan.nextDouble();
					System.out.print("Enter quantity : ");
					quantity = scan.nextInt();
					System.out.print("Enter Discount available : ");
					promotionDiscount = scan.nextInt();
					cart.addItem(name, quantity, price, promotionDiscount);
					break;
					
				case '2' :
					System.out.print("Enter item's name to be removed : ");		// Inquiring which element is to be deleted 
					name = scan.next();
					cart.removeItem(name);
					break;
					
				case '3' :
					System.out.print("Enter item's name to be updated : ");		// Inquiring which element is to be updated 
					name = scan.next();
					System.out.print("Enter new Quantity : ");
					quantity = scan.nextInt();
					cart.updateItem(name, quantity);
					break;
					
				case '4' :
					cart.showItems();
					break;
					
				case '5' :
					String userCode;
					System.out.print("Enter Promo code (Enter no if you don't have any) : ");
					userCode = scan.next();
					cart.showBill(fixedOrderPromotion, fixedProductPromotion, userCode);
					break;
				case '6' :
					System.exit(0);
				default :
					System.out.println("Wrong input!!! TRY AGAIN.");
			}
			
		}
	}
}
