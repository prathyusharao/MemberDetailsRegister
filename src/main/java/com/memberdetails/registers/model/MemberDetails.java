package com.memberdetails.registers.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class MemberDetails {
	
	public MemberDetails() {
	}


	public MemberDetails(String name, String address, String state, String country, String phoneno, String emailid,
			String pan) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.phoneno = phoneno;
		this.emailid = emailid;
		this.pan = pan;
	}


	@Id
	private String id;
	@NotEmpty(message = "First name is required")
	@Pattern(regexp="[a-zA-Z]+\\.?",
    message="name is invalid")
	private String name;
	private String address;
	private String state;
	private String country;
	@NotEmpty
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
    message="Mobile number is invalid")
	private String phoneno;
	private String emailid;
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
    private String pan;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", state=" + state + ", country="
				+ country + ", phoneno=" + phoneno + ", emailid=" + emailid + ", pan=" + pan + "]";
	}


}