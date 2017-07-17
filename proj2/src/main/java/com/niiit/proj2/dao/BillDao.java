package com.niiit.proj2.dao;

import com.niiit.proj2.model.Bill;

public interface BillDao {

	public void addBill(Bill bill);

	public Bill returnbill(int id);

}
