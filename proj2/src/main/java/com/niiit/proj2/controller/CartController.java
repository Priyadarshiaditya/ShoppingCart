/**
 * 
 */
package com.niiit.proj2.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.proj2.dao.CartDao;
import com.niiit.proj2.dao.CartItemDao;
import com.niiit.proj2.dao.CategoryDao;
import com.niiit.proj2.dao.ProductDao;
import com.niiit.proj2.dao.UsersDao;
import com.niiit.proj2.model.Cart;
import com.niiit.proj2.model.CartItem;
import com.niiit.proj2.model.Product;
import com.niiit.proj2.model.Users;


/**
 * @author Jo
 *
 */
@Controller
public class CartController {
	@Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 @Autowired 
	 UsersDao userDao;
	 @Autowired
	 CartDao cartDao;
	 @Autowired
	 CartItemDao cartItemDao;
	 
	
	 @RequestMapping("/cart/showCart")
	 public ModelAndView showProduct(Principal principal,HttpSession session){
		 String id=principal.getName();
		 ModelAndView mv = new ModelAndView("cart");
		 Cart cart= (Cart) session.getAttribute("cart");
		 List<CartItem> cartItems=cartItemDao.getCartItemByUserId(id);
		 if(cartItems ==null || cartItems.size()==0)
		 {
			 mv.addObject("errMsg", "No Items in Cart");
		 }
		 else
		 {
			 mv.addObject("cartContent",cartItemDao.getCartItemByUserId(id));
			// mv.addObject("grandTotal", cart.getGrandTotal());
		 }
		 return mv;
	 }
	 
	/* private void updateCart(CartItem cartItem)
	 {
		 Cart c1=cartItem.getCart();
		 c1.setGrandTotal(c1.getGrandTotal()+cartItem.getProduct().getProductPrice());
		 cartDao.saveOrUpdate(c1);
	 }
	 */
	 @RequestMapping("/cart/addItem/{productId}")
	 public ModelAndView addItemToCart(@PathVariable int productId, Principal principal, HttpSession session){
		 ModelAndView mv = new ModelAndView("redirect:/cart/showCart");
		 String id = principal.getName();
		 System.out.println("logged in user "+id);
		 Product product = productDao.listByProductId(productId);
		 Users u=userDao.getUsersById(id);
		 //Cart cart = cartDao.getCartByUserId(id);
		 Cart cart=u.getCart();
		
		 System.out.println("Yes cart");
		 
		 List <CartItem> cartItems = cartItemDao.getCartItemByUserId(id);
		 
		 for(CartItem cartItem:cartItems)
		 {
			if(cartItem.getProduct().getProductId()==productId)
			{
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setSubTotal(cartItem.getSubTotal()+product.getProductPrice());
				cartItem.setStatus("N");
				cartItemDao.saveOrUpdate(cartItem);
			//updateCart(cartItem);
				session.setAttribute("cart", cartItem.getCart());
				return mv;
			}
		 }
		 
		 CartItem item = new CartItem();
		 item.setCart(cart);
		 item.setProduct(product);
		 item.setStatus("N");
		 item.setQuantity(1);  
		 item.setSubTotal(product.getProductPrice()); 
		 cartItemDao.saveOrUpdate(item);
		 //updateCart(item);
		 session.setAttribute("cart", item.getCart());
		 return mv;
		 
	 }
	 @RequestMapping("/cart/deleteItem/{cartItemId}")
	 public ModelAndView deleteFromCart(@PathVariable int cartItemId,Principal principal,HttpSession session){
			
		 cartItemDao.delete(cartItemId);
	        return new ModelAndView("redirect:/cart/showCart"); 
	 }
	
 }