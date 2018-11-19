package hw5;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Title: OnlineStore.java
 * Abstract: Main file for online store
 * Name: Shawn Deppe
 * Date: 11-9-2018
 */

public class OnlineStore {
	private String name = "CSUMB";
	Random random = new Random();
	boolean state = true;
	private HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>(); 
	private HashMap<Integer, Product> products = new HashMap<Integer, Product>();
	private HashMap<Integer, Product> order = new HashMap<Integer, Product>();
	
	public void welcomeMessage() {
		System.out.println("Welcome to " + name + " OnlineStore");
	}
	
	public void info() {
		System.out.println("Select your choice:");
		System.out.println("\t1. Add Customer");
		System.out.println("\t2. Customer Info");
		System.out.println("\t3. Add Product");
		System.out.println("\t4. Delete Product");
		System.out.println("\t5. Product Info");
		System.out.println("\t6. Make Order");
		System.out.println("\t7. Exit");
	}
	
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public void space() {
		System.out.println("");
		System.out.println("");
	}
	
	public void createCustomer() {
		Scanner nameIn = new Scanner(System.in);
		// random number 100-300
		// check number
		int number;
		do {
			number = getRandomNumberInRange(100, 300);
		} while(customers.containsKey(number));
		System.out.println("Customer Number: " + number);
		// take name
		System.out.print("Customer Name: ");
		String name = nameIn.nextLine();
		// call customer constructor	
		// write to hash
		customers.put(number, new Customer(number, name));
		// print result
		System.out.println("Customer Added - " + name + " (# " + number + ")");
	}
	
	public void printCustomers() {
		// print there are no customers
		if (customers.isEmpty()) {
			System.out.println("No customer information.");
		}
		// print customers
		else {
			System.out.println("===== " + customers.size() + " Customers =====");
			for (int key : customers.keySet()) {
				System.out.println(customers.get(key));
			}
		}
	}
	
	public void createProduct() {
		Scanner productIn = new Scanner(System.in);
		// random number 500-700
		// check number
		int number;
		do {
			number = getRandomNumberInRange(500, 700);
		} while(products.containsKey(number));
		System.out.println("Product Number: " + number);
		// take name
		System.out.print("Product Name: ");
		String name = productIn.nextLine();
		// take price
		System.out.print("Product Price: ");
		double price = productIn.nextDouble();
		// call product constructor
		// write to hash
		products.put(number, new Product(number, name, price));
		// print result
		System.out.println("Product Added - " + name + ", No: " + number + ", Price: " + price);
	}
	
	public void deleteProduct() {
		Scanner productNum = new Scanner(System.in);
		// enter number
		// check if number exists
		// delete number if exists
		System.out.print("Enter a product number to delete: ");
		int num = productNum.nextInt();
		if (products.containsKey(num)) {
			System.out.println("Product " + num + " deleted.");
			products.remove(num);
		}
		else {
			System.out.println("Input Error: Product " + num + " doesn’t exist.");
		}
	}
	
	public void displayProducts() {
		Scanner input = new Scanner(System.in);
		int num;
		// get input
		// check number
		// print DNE, item, or all
		if (products.isEmpty()) {
			System.out.println("No product information.");
		}
		else {
			System.out.print("Enter product number (or just enter to display all products): ");
			try {
				num = input.nextInt();
				if (products.containsKey(num)) {
					System.out.println(products.get(num));
				}
				else {
					System.out.println("Input Error: Product " + num + " doesn't exist.");
				}
			}
			catch (Exception e) {
			}
		}
		
	}
	
	public void makeOrder() {
		Scanner in = new Scanner(System.in);
		int customer;
		int product;
		double total = 0;
		// generate order number
		int number = getRandomNumberInRange(1000, 2000);
		System.out.println("Order Number: " + number);
		// type customer number - error DNE - exit
		System.out.print("Type Customer Number: ");
		customer = in.nextInt();
		if (customers.containsKey(customer)) {
			// type product number - error DNE - continue
			// enter 0 to end
			do {
				System.out.print("Type Product Number (0 to finish): ");
				product = in.nextInt();
				if (products.containsKey(product)) {
					if (product != 0) {
						order.put(product, products.get(product));
					}
				}
				else {
					System.out.println("Input Error: Product " + product + " does not exist.");
				}
			} while (product != 0);
			System.out.println("Order Summary - Order Number: " + number + ", Customer: " + customers.get(customer).getCustomerName());
			int count = 1;
			for (int key : order.keySet()) {
				System.out.println("\tItem " + count + ": " + products.get(key).getProductName() + ": $" + products.get(key).getPrice());
				total = total + products.get(key).getPrice();
				count++;
			}
			System.out.println("\tTotal Price: $" + total);
		}
		else {
			System.out.println("Input Error: Customer number " + customer + " doesn't exist.");
		}
		// print summary
	}
	
	public void inputSwitch(int x) {
		if (x == 1) {
			createCustomer();
		}
		if (x == 2) {
			printCustomers();
		}
		if (x == 3) {
			createProduct();
		}
		if (x == 4) {
			deleteProduct();
		}
		if (x == 5) {
			displayProducts();
		}
		if (x == 6) {
			makeOrder();
		}
		if (x == 7) {
			state = false;
			System.out.println("Bye!");
		}
	}
	
	public void mainProgram() {
		Scanner input = new Scanner(System.in);
		welcomeMessage();
		int x = 0;
		while (state == true) {
			info();
			System.out.println("enter a number:");
			if(input.hasNextLine())
				x = input.nextInt();
			inputSwitch(x);
			space();
		}
	}
}
