package com.takeo.model;

public class Student {
	private int sid;
	private String firstName;
	private String lastName;
	private String sAddress;
	private String email;
	
	//Parameterized constructor
	public Student(String firstName, String lastName, String sAddress, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sAddress = sAddress;
		this.email = email;
	}
    //constructors with all fields for retrieval of data from database
	public Student(int sid, String firstName, String lastName, String sAddress, String email) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sAddress = sAddress;
		this.email = email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
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
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
