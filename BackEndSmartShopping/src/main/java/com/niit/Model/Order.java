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
@Table(name="OrderItem")
public class Order implements Serializable {
	 @Id
	  
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 private String u_id;
	  private String address;
	  private String city;
	  private String state;
	  private String pin;
	  private Float totalBill;
	public Float getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Float totalBill) {
		this.totalBill = totalBill;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAddress() {
		return address;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	  
	  
	  
	  
}
