package com.niiit.proj2.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Users implements Serializable
{



	@Id
    @Column(name="userid")
	private String userId;
	@NotEmpty(message = "Please enter User Name")
	private String userName;
	private String password;
	private boolean enabled;
	private boolean discontinue;
	private String userRole;
	@OneToMany(mappedBy="users")
	List<Bill> bill;





	public boolean isDiscontinue() {
		return discontinue;
	}






	public void setDiscontinue(boolean discontinue) {
		this.discontinue = discontinue;
	}






	public List<Bill> getBill() {
		return bill;
	}






	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}






	public Cart getCart() {
		return cart;
	}






	public void setCart(Cart cart) {
		this.cart = cart;
	}




	public String getUserRole() {
		return userRole;
	}




	@OneToOne
	@JoinColumn(name="cartId")
	Cart cart;
	

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public boolean isEnabled() {
		return enabled;
	}






	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}






	@Transient
	private MultipartFile file;
	
	private String userImage;

	
	public MultipartFile getFile() {
		return file;
	}






	public void setFile(MultipartFile file) {
		this.file = file;
	}






	public String getUserImage() {
		return userImage;
	}






	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}







	
	
	



	public String getUserId() {
		return userId;
	}






	public void setUserId(String userId) {
		this.userId = userId;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}


public Users()
	{
	}
	// parameterised constructor
	// getter setter
	// validation
}

 
