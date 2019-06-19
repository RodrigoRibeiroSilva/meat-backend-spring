package com.rodrigor.meat.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrderPurchase extends BaseObject {
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne()
	@JoinColumn(name = "client_id")
	private Client client;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "created_at", nullable = true, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "updated_at", nullable = true)
	@UpdateTimestamp
	private Date updatedAt;
	
	
	@OneToMany(mappedBy = "id.orderPurchase")
	private Set<OrderItem> items = new HashSet<>();

	public OrderPurchase() {

	}

	public OrderPurchase(Client client) {
		this.client = client;

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
}
