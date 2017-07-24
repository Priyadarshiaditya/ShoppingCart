package com.niiit.proj2.dao;
import com.niiit.proj2.model.*;
import java.util.List;


public interface CategoryDao {

	public List<Category> list();
	public List<Product> listByCategoryId(int categoryId) ;
	public Product listByProductId(int productId);
	
	public void addProduct(Product product);
	public void addCategory(Category category);
	public Category getByCategoryId(int categoryId);
	public void updateCategory(Category category);
	public void deleteCategory(int id);
}
