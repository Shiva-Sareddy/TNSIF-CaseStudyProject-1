package org.tns.onlineshopping.entities;

public class ProductQuantityPair {
	
	// Attributes
	private Product product;
	private int quantity;
	
	// Constructor
	public ProductQuantityPair(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	
	// Getters and Setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
