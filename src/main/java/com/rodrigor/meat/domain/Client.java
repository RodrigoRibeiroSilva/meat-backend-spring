package com.rodrigor.meat.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.rodrigor.meat.domain.enums.Profile;

@Entity
public class Client extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	private String name, email, address, number, optionalAddress, password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILE")
	private Set<Integer> profiles = new HashSet<>();
	
	public Client() {
		addProfile(Profile.CLIENT);
	}

	public Client(String name, String email, String address, String number,
			String optionalAddress, String password) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.number = number;
		this.optionalAddress = optionalAddress;
		this.setPassword(password);
		addProfile(Profile.CLIENT);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOptionalAddress() {
		return optionalAddress;
	}

	public void setOptionalAddress(String optionalAddress) {
		this.optionalAddress = optionalAddress;
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
	
	public Set<Profile> getProfile(){
		return profiles.stream().map(perfil -> Profile.toEnum(perfil)).collect(Collectors.toSet());
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", email=" + email + ", emailConfirmation="  + ", address="
				+ address + ", number=" + number + ", optionalAddress=" + optionalAddress + "]";
	}

}
