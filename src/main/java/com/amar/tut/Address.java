package com.amar.tut;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@Column(name = "STREET")
	private String street;
	@Column(length = 50)
	private String city;
	@Transient
	private double x;
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;
	@Lob
	private byte[] image;
	@Column(name = "open")
	private boolean isOpen;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(int addressId, String street, String city, double x, Date addedDate, byte[] image, boolean isOpen) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
		this.isOpen = isOpen;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public boolean isOpen() {
		return isOpen;
	}


	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
}
