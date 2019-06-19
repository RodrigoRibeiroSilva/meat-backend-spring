package com.rodrigor.meat.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();

	private Integer quantity;
	private BigDecimal price;

	public OrderItem() {

	}

	public OrderItem(OrderPurchase order, MenuItem menuItem, Integer quantity, Double price) {
		this.id.setOrderPurchase(order);
		this.id.setMenuItem(menuItem);
		this.quantity = quantity;
		this.price = new BigDecimal(price);
	}
	
	@JsonIgnore
	public OrderPurchase getOrderPurchase() {
		return id.getOrderPurchase();
	}
	
	
	public MenuItem getMenuItem() {
		return id.getMenuItem();
	}

	public OrderItemPk getId() {
		return id;
	}

	public void setId(OrderItemPk id) {
		this.id = id;
	}

	public OrderItem(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItem [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
