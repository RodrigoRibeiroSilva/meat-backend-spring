package com.rodrigor.meat.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItemPk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="orderPurchase_id")
	private OrderPurchase orderPurchase;
	
	@ManyToOne
	@JoinColumn(name="menuItem_id")
	private MenuItem menuItem;

	public OrderPurchase getOrderPurchase() {
		return orderPurchase;
	}

	public void setOrderPurchase(OrderPurchase order) {
		this.orderPurchase = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItem == null) ? 0 : menuItem.hashCode());
		result = prime * result + ((orderPurchase == null) ? 0 : orderPurchase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		if (menuItem == null) {
			if (other.menuItem != null)
				return false;
		} else if (!menuItem.equals(other.menuItem))
			return false;
		if (orderPurchase == null) {
			if (other.orderPurchase != null)
				return false;
		} else if (!orderPurchase.equals(other.orderPurchase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItemPk [order=" + orderPurchase + ", menuItem=" + menuItem + "]";
	}

}
