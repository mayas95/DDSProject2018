package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customerorderitem")
public class CustomerOrderItem implements Serializable {

	private static final long serialVersionUID = -2455760938054036364L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerOrderItemId;

	private int quality;

	private double price;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "customerOrderId")
	@JsonIgnore
	private CustomerOrder customerOrder;

	public String getCustomerOrderItemId() {
		return customerOrderItemId;
	}

	public void setCustomerOrderItemId(String customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
}
