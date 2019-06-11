package com.rodrigor.meat.domain.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public CredentialsDTO() {
		
	}

	public CredentialsDTO(String email, String senha) {
		this.email = email;
		this.password = senha;
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

	public void setSenha(String senha) {
		this.password = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		CredentialsDTO other = (CredentialsDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
