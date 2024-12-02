package org.tns.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.tns.onlineshopping.entities.Order;
import org.tns.onlineshopping.entities.Product;
import org.tns.onlineshopping.entities.ProductQuantityPair;

public class OrderService {
	private List<Order> orderList = new ArrayList<>();

	public OrderService() {
	}

	public void placeOrder(Order order) {
		orderList.add(order);
	}

	public void updateOrderStatus(int orderId, String status) {
		Order order = getOrder(orderId);

		if (order != null) {
			if ("Completed".equalsIgnoreCase(status)) {
				if("Pending".equalsIgnoreCase(order.getStatus())) {
					for (ProductQuantityPair pair : order.getProducts()) {
						Product product = pair.getProduct();
						int quantity = pair.getQuantity();

						if (product.getStockQuantity() >= quantity) {
							product.setStockQuantity(product.getStockQuantity() - quantity);
							order.setStatus("Completed");
						    System.out.println("Order status updated to Completed.");
						} 
						else {
							System.out.println("Insufficient stock for product: " + product.getName());
							return;
						}
					}
				}
				else {
					System.out.println("Failed to Update Order Status.(Order already Delivered)");
				}
			} 
			else if ("Cancelled".equalsIgnoreCase(status)) {
				if ("Completed".equalsIgnoreCase(order.getStatus()) || "Pending".equalsIgnoreCase(order.getStatus())) {
					for (ProductQuantityPair pair : order.getProducts()) {
						Product product = pair.getProduct();
						int quantity = pair.getQuantity();
						product.setStockQuantity(product.getStockQuantity() + quantity);
					}
					order.setStatus("Cancelled");
				    System.out.println("Order status updated to Cancelled.");
				}
				else {
					System.out.println("Failed to Update Order Status.(Order Already Delivered)");
				}
			} 
			else if ("Delivered".equalsIgnoreCase(status)) {
				if("Completed".equalsIgnoreCase(order.getStatus())) {
					order.setStatus("Delivered");
				    System.out.println("Order status updated to Delivered.");
				}
				else {
					System.out.println("Failed to Update Order Status.(Not yet Completed/Order Cancelled)");
				}
			}
		} 
		else
			System.out.println("Invalid Order");
	}

	public Order getOrder(int orderId) {
		return orderList.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
	}

	public List<Order> getOrders() {
		return orderList;
	}
}
