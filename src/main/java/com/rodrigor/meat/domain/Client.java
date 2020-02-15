package com.rodrigor.meat.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigor.meat.domain.enums.Profile;

@Entity
public class Client extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	private String name, email;
	private String password;
	
	@OneToOne
	private Address activatedAddress;
	
	@JsonIgnore
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Address> addressList = new ArrayList<Address>();
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<OrderPurchase> orderList = new ArrayList<OrderPurchase>();
	
	@JsonIgnore
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILE")
	private Set<Integer> profiles = new HashSet<>();
	
	public Client() {
		addProfile(Profile.CLIENT);
	}

	public Client(String name, String email, Address address, String password) {
		this.name = name;
		this.email = email;
		this.addressList.add(address);
		this.setPassword(password);
		this.activatedAddress = this.addressList.get(0);
		addProfile(Profile.CLIENT);
	}
	
	

	public Address getActivatedAddress() {
		return activatedAddress;
	}

	public void setActivatedAddress(Address activatedAddress) {
		this.activatedAddress = activatedAddress;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<OrderPurchase> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderPurchase> orderList) {
		this.orderList = orderList;
	}

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addProfile(Profile profile) {
		profiles.add(profile.getId());
	}
	
	
	public void addAddressList(Address address) {
		addressList.add(address);
	}
	
	public Set<Profile> getProfile(){
		return profiles.stream().map(perfil -> Profile.toEnum(perfil)).collect(Collectors.toSet());
	}

}
