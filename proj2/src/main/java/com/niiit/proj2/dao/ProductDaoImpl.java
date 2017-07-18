package com.niiit.proj2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.proj2.model.Category;
import com.niiit.proj2.model.Product;
import com.niiit.proj2.model.Users;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	
	
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		protected Session getSession() {
			return sessionFactory.openSession();
		}
		


	public List<Product> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
        session.close();
		return productList;
	}
	public List<Product> listByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productCategory.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		List<Product> productList = query.list();
        session.close();
        System.out.println("list "+productList);
		return productList;
	}
	
	public Product listByProductId(int productId) {
		// TODO Auto-generated method stub
				Session session = getSession();

		Query query = session.createQuery("from Product where productId = '"+ productId+"'");
		List<Product> productList = query.list();
        session.close();

		if(productList ==null || productList.size()==0)
		{
			return null;
		}
		else
		{
			return productList.get(0);
		}
        
			}
	
	public void addProduct(Product product ) {
		// TODO Auto-generated method stub

		Session session = getSession();

	
		
		product.setDiscontinue(false);

		session.save(product);

		session.flush();

		session.close();

	}
	public List<Product> getAllProducts()
	{
		
		Session session = getSession();

		Query query = session.createQuery("from Product where discontinue=false");
		List<Product> customerList = query.list();

		return customerList;

	}
	public  Product getProductsById(int id)
	{
		Session session = getSession();
		return (Product) session.get(Product.class, id);
	}
	public void updateProduct(Product product)
	{
		Session session = getSession();

		String s = product.getProductName();

		session.update(product);
		session.flush();

		session.close();
	}
	public void deleteProduct(int id) {
	
		
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = ?");
		query.setInteger(0,id);

		Product u=(Product) query.uniqueResult();
		u.setDiscontinue(true);
		session.save(u);
		session.flush();

		session.close();
		
	}

}


