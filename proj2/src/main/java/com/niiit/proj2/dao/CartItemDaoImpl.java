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
import com.niiit.proj2.model.Users;

/**
 * @author Jo
 *
 */
@EnableTransactionManagement
@Repository("cartItemDao")
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CartItemDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public CartItemDaoImpl(){}

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
	
	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	@Transactional
	public boolean saveOrUpdate(CartItem cartItem){
		try{
			Session session = getSession();
			session.saveOrUpdate(cartItem);
			session.flush();
			session.close();
			
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	@Transactional
	public void delete(int cartId)
	{
		try{
			Session session = getSession();
			Query query = session.createQuery("from CartItem where cartItemId = ?");
			query.setInteger(0, cartId);
			CartItem c=new CartItem();
			c=(CartItem)query.uniqueResult();
			session.delete(c);
			session.flush();
			session.close();
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}

	public CartItem get(String cartItemId){

		String hql = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
		
		Session session = getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		
		List<CartItem> list = query.list();
		
		session.flush();
		session.close();
		if(list == null || list.isEmpty())
		{
			
			return null;
		}
		else
		{
			
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<CartItem> getCartItemByUserId(String userId){
		Session session = getSession();
		String hql = "from CartItem where cart.user.userId=" + "'" + userId + "'" + "and status = 'N'";
		Query query = session.createQuery(hql);
		return query.list();
	}
}
