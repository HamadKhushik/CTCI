package objectOrientedDesign.amazonShoppingSystem;

import java.util.Date;
import java.util.List;

/**
 * This file contains classes for ShoppingCart, Item, Order and OrderLog
 * 
 * @author Hammad: 06-Feb-2022
 */
public class Item {
	private String productId;
	private int quantity;
	private double price;

	public boolean updateQuantity() {
		System.out.println("Returning false from updateQuantity() in Item class");
		return false;
	}
}

class ShoppingCart {
	private List<Item> items;

	public boolean addItem() {
		System.out.println("Returning false from addItem() in ShoppingCart class");
		return false;
	}

	public boolean removeItem() {
		System.out.println("Returning false from removeItem() in ShoppingCart class");
		return false;
	}

	public boolean updateItemQuantity(Item item, int quantity) {
		System.out.println("Returning false from removeItem() in ShoppingCart class");
		return false;
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean checkout() {
		System.out.println("Returning false from checkout() in ShoppingCart class");
		return false;
	}
}

class OrderLog {
	private String orderNumber;
	private Date creationDate;
	private OrderStatus status;
}

class Order {
	private String orderNumber;
	private OrderStatus status;
	private Date orderDate;
	private List<OrderLog> orderLog;

	public boolean sendForShipment() {
		System.out.println("Returning false from sendForShipment() in Order class");
		return false;
	}

	public boolean makePayment(Payment payment) {
		System.out.println("Returning false from makePayment() in Order class");
		return false;
	}

	public boolean addOrderLog(OrderLog orderLog) {
		System.out.println("Returning false from addOrderLog() in Order class");
		return false;
	}
}
