/**
 * 
 */
package com.niiit.proj2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.proj2.model.Cart;
import com.niiit.proj2.model.CartItem;

/**
 * @author Jo
 *
 */
@EnableTransactionManagement
@Repository(value="cartDAO")

public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public CartDaoImpl(){}

	/**
	 * @return the sessionFactory
	 */

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession()
	{
		return sessionFactory.openSession(); 
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveOrUpdate(Cart cart)
	{
		try{
			Session session = getSession();
			session.saveOrUpdate(cart);
			session.flush();
			session.close();
			
			return true;
			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	@Transactional
	public boolean delete(Cart cart)
	{
		try{
			Session session =getSession();
			session.delete(cart);
			session.flush();
			session.close();
			
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart getCartByUserId(String userId)
	{	
		String hql = "from Cart where user.userId=" + "'" + userId + "'";
		
		Session session = getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		
		List<Cart> list = query.list();
		
		if(list == null || list.isEmpty())
		{
			session.flush();
			session.close();
			return null;
		}
		else
		{
			session.flush();
			session.close();
			return list.get(0);
		}
	}
	public List<CartItem> getCartItemsByCartId(int cart) {
		Session session = getSession();
		String h = "from CartItem where cart.cartId=" + cart+" and status ='N'" ;
		Query q = session.createQuery(h);
		return q.list();
	}
}


