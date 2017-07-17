/**
 * 
 */
package com.niiit.proj2.dao;

import com.niiit.proj2.model.Cart;

/**
 * @author Jo
 *
 */
public interface CartDao {

	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart getCartByUserId(String userId);
	
}
