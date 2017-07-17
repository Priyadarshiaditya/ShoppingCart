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
public interface CartItemDao {

	public boolean saveOrUpdate(CartItem cartItem);
	
	public void delete(int productId);
	
	public CartItem get(String cartItemId);
	
	public List<CartItem> getCartItemByUserId(String userId);
	
}
