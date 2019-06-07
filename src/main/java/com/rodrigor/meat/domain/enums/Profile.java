package com.rodrigor.meat.domain.enums;

public enum Profile {
	ADMIN(1, "ROLE_ADMIN"), 
	CLIENT(2, "ROLE_CLIENTE");

	private int id;
	private String description;
	
	private Profile(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Profile toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (Profile profile : Profile.values()) {
			if (id.equals(profile.getId())) {
				return profile;
			}
		}

		throw new IllegalArgumentException("Código: " + id + "inválido");
	}

}
