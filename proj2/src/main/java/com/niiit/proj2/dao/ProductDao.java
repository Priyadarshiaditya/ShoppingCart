package com.niiit.proj2.dao;

import java.util.List;


import com.niiit.proj2.model.Product;

public interface ProductDao {
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public  Product getProductsById(int id);
	public void updateProduct(Product product);
	public void deleteProduct(int id); 
}
