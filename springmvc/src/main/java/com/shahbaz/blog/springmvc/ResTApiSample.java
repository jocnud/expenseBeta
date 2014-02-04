package com.shahbaz.blog.springmvc;

public class ResTApiSample {

	private String firstName;

	private String lastName;

	ResTApiSample() {
		System.out.println("inside default");
	}

	ResTApiSample(String firstName, String lastName) {
		System.out.println(" Setting " + firstName + " " + lastName);
		this.firstName = firstName;
		this.lastName = lastName;
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

}
