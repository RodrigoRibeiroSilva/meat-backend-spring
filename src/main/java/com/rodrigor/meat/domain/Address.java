package com.rodrigor.meat.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address extends BaseObject {
	private static final long serialVersionUID = 1L;

	private String address, optionalAddress, number, zipCode;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Address() {

	}

	public Address(String address, String optionalAddress, String number, String zipCode) {
		this.address = address;
		this.optionalAddress = optionalAddress;
		this.number = number;
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOptionalAddress() {
		return optionalAddress;
	}

	public void setOptionalAddress(String optionalAddress) {
		this.optionalAddress = optionalAddress;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Address [address=" + address + ", optionalAddress=" + optionalAddress + ", number=" + number + "]";
	}
}
