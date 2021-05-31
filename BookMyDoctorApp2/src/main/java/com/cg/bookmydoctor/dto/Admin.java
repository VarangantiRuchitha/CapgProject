package com.cg.bookmydoctor.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admin {

	@Id
	@Column(name = "adminId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	
	@Column(name= "adminName")
	private String adminName;
	
	@Column(name="contactNumber")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Admin() {}
	

	public Admin(int adminId, String adminName, String contactNumber, String email, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", password=" + password + "]";
	}

	
}
