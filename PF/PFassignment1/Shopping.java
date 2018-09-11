package get_assignment1;

import java.util.*;

class Item {
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    HashMap<String, Item> cart = new HashMap<String, Item>();

    public void addItem() {
        String name;
        int quantity;
        double price;

        System.out.print("Enter item's name : ");
        name = System.console().readLine();
        System.out.print("Enter item's price : ");
        price = Double.parseDouble(System.console().readLine());
        System.out.print("Enter quantity : ");
        quantity = Integer.parseInt(System.console().readLine());

        Item newItem = new Item(name, quantity, price);
        cart.put(name, newItem);
    }

    public void removeItem() {
        String name;
        System.out.print("Enter item's name to be removed : ");
        name = System.console().readLine();
        Item value = Item.class.cast(cart.get(name));
        if (value != null) {
            System.out.println("Item successfully removed.");
            cart.remove(name);
        } else
            System.out.println("Item not found!!!");
    }

    public void updateItem() {
        String name;
        int quantity;
        double price;

        System.out.print("Enter item's name to be updated : ");
        name = System.console().readLine();

        Item value = Item.class.cast(cart.get(name));
        if (value != null) {
            cart.remove(name);
            System.out.print("Enter item's name : ");
            name = System.console().readLine();
            System.out.print("Enter item's price : ");
            price = Double.parseDouble(System.console().readLine());
            System.out.print("Enter quantity : ");
            quantity = Integer.parseInt(System.console().readLine());
            Item newItem = new Item(name, quantity, price);
            cart.put(name, newItem);
        } else
            System.out.println("Item not found!!!");
    }

    public void showItems() {
        System.out.println("\nItem Details\n");
        for (Object obj : cart.values()) {
            Item item = Item.class.cast(obj);
            System.out.println("Name : " + item.getName());
            System.out.println("Price : " + item.getPrice());
            System.out.println("Quantity : " + item.getQuantity() + "\n");
        }
    }

    public void showBill() {
        double total = 0.0;
        System.out.println("\nTotal bill\n");
        for (Object obj : cart.values()) {
            Item item = Item.class.cast(obj);
            System.out.println(item.getName() + " : " + item.getQuantity() + "x" + item.getPrice());
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("Final Payment : " + total + "\n");
    }
}

public class Shopping {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        char proceed;
        int choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\nShopping Cart menu\n");
            System.out.println("1.Add an item");
            System.out.println("2.Remove an item");
            System.out.println("3.Update an item");
            System.out.println("4.Show all cart items");
            System.out.println("5.Show total bill");
            choice = scan.nextInt();

            switch (choice) {
            case 1:
                cart.addItem();
                break;
            case 2:
                cart.removeItem();
                break;
            case 3:
                cart.updateItem();
                break;
            case 4:
                cart.showItems();
                break;
            case 5:
                cart.showBill();
                break;
            default:

            }

            System.out.println("Do you want to continue(Y/N) : ");
            proceed = scan.next().charAt(0);
        } while (proceed == 'Y' || proceed == 'y');
    }
}