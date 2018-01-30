package com.niit.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	private String email;
	
	
	private String name;
	private String phone;
	private String	address;
	private String	password;
	private String	country;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/*public User(String email, String name, String phone, String address, String password, String country) {
	
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.country = country;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", phone=" + phone + ", address=" + address + ", password="
				+ password + ", country=" + country + "]";
	}
	
	
}
