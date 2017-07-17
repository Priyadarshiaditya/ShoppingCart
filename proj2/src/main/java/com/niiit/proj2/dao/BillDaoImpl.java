package com.niiit.proj2.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.proj2.model.Bill;
import com.niiit.proj2.model.Product;
@Repository("billDao")
@Transactional
public class BillDaoImpl implements BillDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	public void addBill(Bill bill) {
		// TODO Auto-generated method stub

		Session session = getSession();



		
		session.save(bill);

		session.flush();

		session.close();
	}
	public Bill returnbill(int billId)
	{
		Session session = getSession();
		Query query = session.createQuery("from Bill where billId=?");
		query.setInteger(0,billId);
		
		Bill bill = (Bill)query.uniqueResult();

		return bill;
	}
}
