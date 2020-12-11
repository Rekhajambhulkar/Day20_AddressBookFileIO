package com.bridgelabz.addressbook;

import java.util.Scanner;
import java.lang.String;
import java.lang.Object;
import java.util.Comparator;


public class Person {
	
	private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String emailId;
   
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return firstName+ " [firstName=" + firstName + ","
								+ "lastName=" + lastName + ", "
								+ "address=" + address +","
								+ "city=" + city + ","
								+ "state=" + state + ", "
								+ "zip=" + zip + ", "
								+ "phoneNumber=" + phoneNumber + ", "
								+ "emailId="+ emailId + "]";
	}
}
