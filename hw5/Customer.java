package hw5;

/*
 * Title: Customer.java
 * Abstract: customer class for creating customer objects for online store
 * Name: Shawn Deppe
 * Date: 11-9-2018
 */


public class Customer {
	private int customerNumber;
	private String customerName;
	
	public Customer(int customerNumber, String customerName) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public int getCustomerNUmber() {
		return this.customerNumber;
	}
	
	public String toString() {
		String result; 
		result = (this.customerName + " - " + this.customerNumber);
		return result;
	}
}