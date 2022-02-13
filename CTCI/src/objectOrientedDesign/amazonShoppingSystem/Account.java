package objectOrientedDesign.amazonShoppingSystem;

import java.util.List;

/**
 * File containing classes for Account, Customer, Admin, Member and Guest
 * classes for all the user accounts
 * 
 * @author Hammad: 05-Feb-2022
 */
public class Account {
	private String username;
	private String password;
	private AccountStatus status;
	private String name;
	private Address shippingAddress;
	private String email;
	private String phone;

	private List<CreditCard> creditCards;
	private List<ElectronicBankTransfer> bankAccounts;

	public boolean addProduct(Product product) {
		System.out.println("Returning false from addProduct in Account class!");
		return false;
	}

	public boolean addProductReview(ProductReview review) {
		System.out.println("Returning false from addProduct in Account class!");
		return false;
	}

	public boolean resetPassword() {
		System.out.println("Returning false from addProduct in Account class!");
		return false;
	}
}

abstract class Customer {
	private ShoppingCart cart;
	private Order order;

	public ShoppingCart getShoppingCart();

	public boolean addItemToCart(Item item);

	public boolean removeItemFromCart(Item item);
}

class Guest extends Customer {

	public boolean registerAccount() {

	}
}

class Member extends Customer {

	private Account account;

	public OrderStatus placeOrder(Order order) {

	}
}
