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


@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	public List<Category> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
        session.close();
		return categoryList;
	}
	public void updateCategory(Category category)
	{Session session = getSession();



	session.update(category);
	session.flush();

	session.close();
		
	}
	public Category getByCategoryId(int categoryId) {
		Session session = getSession();
		return (Category) session.get(Category.class, categoryId);
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
	public void deleteCategory(int id)
	{
		Session session = getSession();

		Query query = session.createQuery("from Category where CategoryId = ?");
		query.setInteger(0,id);

		Category u=(Category) query.uniqueResult();
	  
		session.delete(u);
		session.flush();

		session.close();
		
	}
	public Product listByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = :productId");
		query.setParameter("productId", productId);
		Product product = (Product)query.uniqueResult();
        session.close();
        
		return product;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub

		Session session = getSession();

		String s = product.getProductName();

		session.save(product);

		session.flush();

		session.close();

	}
	public void addCategory(Category category)
	{
		Session session = getSession();

		
		session.save(category);

		session.flush();

		session.close();
	}
	}

 