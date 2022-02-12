package objectOrientedDesign.amazonShoppingSystem;

import java.util.HashMap;
import java.util.List;

/**
 * File containing interface for search and class for Catalogue
 * 
 * @author Hammad: 07-Feb-2022
 */
public interface Search {
	public List<Product> searchProductByName(String name);

	public List<Product> searchProductByCategory(String category);
}

class Catalogue implements Search {
	HashMap<String, List<Product>> productNames;
	HashMap<String, List<Product>> productCategories;

	public List<Product> searchProductByName(String name) {
		return productNames.get(name);
	}

	public List<Product> searchProductByCategory(String category) {
		return productCategories.get(category);
	}
}
