package com.shopperstack.pojos;

public class CreateUser 
{
	public CreateUser(String city, String country, String email, String firstname, String gender, String lastname,
			String password, Long phonenumber, String state, String zoneid) {
		super();
		this.city = city;
		this.country = country;
		this.email = email;
		this.firstname = firstname;
		this.gender = gender;
		this.lastname = lastname;
		this.password = password;
		this.phonenumber = phonenumber;
		this.state = state;
		this.zoneid = zoneid;
	}
	private String city;
	private String country;
	private String email;
	private String firstname;
	private String gender;
	private String lastname;
	private String password;
	private Long phonenumber;
	private String state;
	private String zoneid;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
