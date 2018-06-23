package com.model;

import com.service.OrderStateFactoryService;
import com.service.OrderStateFactoryService.State;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "customerorder")
public class CustomerOrder implements Serializable {

	private static final long serialVersionUID = -6571020025726257848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerOrderId;

	@OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomerOrderItem> customerOrderItem;

	@Column(name = "totalPrice")
	private Double totalPrice;



	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne
	@JoinColumn(name = "stateId")
	private OrderState orderState;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	/*public Cart getCart() { return cart;}*/

	/*public void setCart(Cart cart) {
		this.cart = cart;
	}*/

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CustomerOrderItem> getCustomerOrderItem() {
		return customerOrderItem;
	}

	public void setCustomerOrderItem(List<CustomerOrderItem> customerOrderItem) {
		this.customerOrderItem = customerOrderItem;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	public void setOrderState(State state) {
		this.orderState = OrderStateFactoryService.buildState(state,this);
	}
}
