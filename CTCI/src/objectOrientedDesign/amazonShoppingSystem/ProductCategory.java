package objectOrientedDesign.amazonShoppingSystem;

/**
 * This file contains classes for ProductCategory, Product and ProductReview
 * 
 * @author Hammad: 05-Feb-2022
 */
public class ProductCategory {
	private String name;
	private String description;
}

class ProductReview {
	private int rating;
	private String review;

	private Member reviewer;
}

class Product {
	private String productId;
	private String name;
	private String descriprion;
	private double price;
	private int availableCount;
	private ProductCategory category;

	private Account seller;

	public int getAvailableCount() {
		return availableCount;
	}

	public boolean updatePrice() {
		System.out.println("Returning false from updatePrice() in Product class");
		return false;
	}
}
