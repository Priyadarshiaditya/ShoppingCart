package com.niiit.proj2.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.proj2.dao.CategoryDao;
import com.niiit.proj2.dao.ProductDao;
import com.niiit.proj2.model.*;

@Controller  
public class ProductController {
	 @Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	  ProductDao productDao;
	 @RequestMapping("/")  
	    public ModelAndView index(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 @RequestMapping("/home1")  
	    public ModelAndView index1(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 @RequestMapping("/showProductsByCategory/{categoryId}")  
	    public ModelAndView showProductsByCategory(@PathVariable int categoryId ){  
		 System.out.println("cat id "+categoryId);
		 ModelAndView mv= new ModelAndView("products");
		 mv.addObject("productList", categoryDao.listByCategoryId(categoryId));
	        return mv;  
	    }  
	 @RequestMapping("/showProduct/{productId}")  
	    public ModelAndView showProduct(@PathVariable int productId ){  
		 
		 ModelAndView mv= new ModelAndView("product");
		 mv.addObject("product", categoryDao.listByProductId(productId));
	        return mv;  
	 }
	 @RequestMapping(value = "/loginPage",method=RequestMethod.GET) 
	  public ModelAndView showLogin(HttpSession session){  
		 
			 ModelAndView mv= new ModelAndView("login");
			 return mv;
		 }
	 @RequestMapping("/managecategory")
	    
	    public ModelAndView addCategory(){
		 
		 ModelAndView mv=  new ModelAndView("managecategory","command",new Category());
		 return mv;
	 } 		
		 @RequestMapping("/manageproduct")
		    
		    public ModelAndView addProduct(){
			 
			 ModelAndView mv=  new ModelAndView("manageproduct","command",new Product());
			 mv.addObject("categoryList",categoryDao.list());
			 return mv;
		 } 		 
		
		 @RequestMapping(value="/save1",method = RequestMethod.POST)  
		    public ModelAndView save(@ModelAttribute("product")Product product, HttpServletRequest request, 
					@RequestParam("file") MultipartFile file )
		 {  

			int pid=product.getProductId();
			  
			  Product temp=productDao.listByProductId(pid);
			  
			  if(temp!=null)
			  {
				  ModelAndView  mv= new ModelAndView("manageproduct","command",product); 
			 		mv.addObject("categoryList", categoryDao.list());
			 		mv.addObject("error", "Product Id already exists");
			         return mv;
			  }
		    	
			 byte fileBytes[];
				FileOutputStream fos = null;
				
				String fileName = "";
				String userImage = "";
				ServletContext context = request.getServletContext();
				String realContextPath = context.getRealPath("/");
				String un = product.getProductName();
				if (file != null){
					fileName = realContextPath + "/resources/img/" + un + ".jpg";
					userImage = "resources/img/" + un + ".jpg";
					System.out.println(fileName );
					File fileobj = new File(fileName);
					try{
						fos = new FileOutputStream(fileobj);
						fileBytes = file.getBytes();
						fos.write(fileBytes);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
						product.setProductImage(userImage);	
				    	
		    	
		    	
			 productDao.addProduct(product);
		        return new ModelAndView("redirect:/home1");//will redirect to viewusers request mapping  
		    }  	 
		 @RequestMapping(value="/save3",method = RequestMethod.POST)  
		    public ModelAndView save3(@ModelAttribute("category")Category category, HttpServletRequest 
		    		request)
		 {  	    	
		    	
			 categoryDao.addCategory(category);
		        return new ModelAndView("redirect:/home1");//will redirect to viewusers request mapping  
		    }  	 
		

		 @RequestMapping("/viewproduct")  
		    public ModelAndView viewusers(){  
		        List<Product> list=productDao.getAllProducts();
		        return new ModelAndView("viewproduct","list",list);  
		    }  
		 @RequestMapping("/viewcategory")  
		    public ModelAndView viewcategory(){  
		        List<Category> list=categoryDao.list();
		        return new ModelAndView("viewcategory","list",list);  
		    }  
		    @RequestMapping(value="/editproduct/{id}")  
		    public ModelAndView edit(@PathVariable int id){  
		        Product product=productDao.getProductsById(id);  
		        ModelAndView mv=new ModelAndView("productseditform","command",product);  
		        System.out.println(product.getProductName()+" mmmmmmm "+product.getProductImage());
		        mv.addObject("photo",product.getProductImage());
		        return mv;  
		    }
		    @RequestMapping(value="/editcategory/{id}")  
		    public ModelAndView edit5(@PathVariable int id){  
		        Category category=categoryDao.getByCategoryId(id);  
		        ModelAndView mv=new ModelAndView("categoryeditform","command",category);  
		        return mv;  
		    }  
		    @RequestMapping(value="/editsave2",method = RequestMethod.POST)  
		    public ModelAndView editsave2(@ModelAttribute("category") Category category,
		    		HttpServletRequest request){  
		    	categoryDao.updateCategory(category);
		        return new ModelAndView("redirect:/viewcategory");	

		    	
		    }		   
		    @RequestMapping(value="/editsave1",method = RequestMethod.POST)  
		    public ModelAndView editsave(@ModelAttribute("product") Product product, HttpServletRequest request, 
					@RequestParam("file") MultipartFile file){  
		    	

		    	if (file.getSize()!=0)
		    		
		    	{
		    		
		    		System.out.println("uiuiuiuiuiuiu"+ file.getSize());
		byte fileBytes[];
		FileOutputStream fos = null;

		String fileName = "";
		String userImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String un = product.getProductName();
		if (file != null){
			System.out.println(" file not null");
		fileName = realContextPath + "/resources/img/" + un + ".jpg";  
		userImage = "resources/img/" + un + ".jpg";
		System.out.println("===" + fileName + "===");
		File fileobj = new File(fileName);
		try{
		fos = new FileOutputStream(fileobj);
		fileBytes = file.getBytes();
		fos.write(fileBytes);
		fos.close();
		} catch(Exception e) {
		e.printStackTrace();
		}
		}

		product.setProductImage(userImage);	 
		    	}
productDao.updateProduct(product);
		        return new ModelAndView("redirect:/viewproduct");  
		    }  
		    @RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.GET)  
		    public ModelAndView delete(@PathVariable int id){ 
		    	
		      productDao.deleteProduct(id);
		        return new ModelAndView("redirect:/viewproduct");  
		    }  
		    @RequestMapping(value="/deletecategory/{id}",method = RequestMethod.GET)  
		    public ModelAndView delete2(@PathVariable int id){ 
		    	
		      categoryDao.deleteCategory(id);
		        return new ModelAndView("redirect:/viewcategory");  
		    }  
		
	 
	
		// TODO Auto-generated method stub
		
	

}