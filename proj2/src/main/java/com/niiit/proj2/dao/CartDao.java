/**
 * 
 */
package com.niiit.proj2.dao;

import java.util.List;

import com.niiit.proj2.model.Cart;
import com.niiit.proj2.model.CartItem;

/**
 * @author Jo
 *
 */
public interface CartDao {

	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart getCartByUserId(String userId);
	public List<CartItem> getCartItemsByCartId(int cart);
	
}
