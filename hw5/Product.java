package hw5;

/*
 * Title: Product.java
 * Abstract: product class creating products for online store
 * Name: Shawn Deppe
 * Date: 11-9-2018
 */


public class Product {
	private int productNumber;
	private String productName;
	private double price;
	
	public Product(int productNumber, String productName, double price) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.price = price;
	}
	
	public int getProductNumber() {
		return this.productNumber;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		String result;
		result = ("No: " + this.productNumber + " - " + this.productName + ", Price: " + this.price);
		return result;
	}
}
