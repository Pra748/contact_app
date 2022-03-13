package com.contactapp.dto;

public class Contactapp {
	private int phone;
	private String name;
	private String email;

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Contactapp [phone=" + phone + ", name=" + name + ", email=" + email + "]";
	}
}
