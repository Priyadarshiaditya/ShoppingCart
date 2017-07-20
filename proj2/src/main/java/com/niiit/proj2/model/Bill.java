package com.niiit.proj2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Bill implements Serializable {
	@Id
	@GeneratedValue
    @Column(name="billId")
	private int billId;
	private Date billDate;
	private double total;
	private String billAddress;
	@ManyToOne
	@JoinColumn(name="userId")
	Users users;

public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getBillAddress() {
		return billAddress;
	}
	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	
}
