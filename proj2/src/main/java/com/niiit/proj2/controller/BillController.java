package com.niiit.proj2.controller;

import java.security.Principal;
import java.util.Date;

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

import com.niiit.proj2.dao.BillDao;
import com.niiit.proj2.dao.CartDao;
import com.niiit.proj2.dao.CategoryDao;
import com.niiit.proj2.dao.ProductDao;
import com.niiit.proj2.dao.UsersDao;
import com.niiit.proj2.model.Bill;
import com.niiit.proj2.model.Product;
import com.niiit.proj2.model.Users;

@Controller
public class BillController {
	@Autowired 
 	  UsersDao usersDao;
	  @Autowired 
	  CartDao cartDao;
	 @Autowired
	 BillDao billDao;
	
	@RequestMapping("/billform")
	 public ModelAndView newBill(){
		 return new ModelAndView("billform","command",new Bill());
	}
		 @RequestMapping(value="/save2",method = RequestMethod.POST)  
		    public ModelAndView savebill(@ModelAttribute("bill") Bill bill , HttpServletRequest request,Principal principal){
			 
			 String id=principal.getName();
 			 Users u=usersDao.getUsersById(id);
			 bill.setUsers(u);
			 
			 bill.setBillDate(new Date(System.currentTimeMillis()));
			 billDao.addBill(bill);
			 int billId=bill.getBillId();
			 return new ModelAndView("redirect:/showbill/"+billId);
}
		 @RequestMapping(value="/showbill/{billId}")  
		    public ModelAndView showbill(@PathVariable int billId, Principal principal, Bill bill){
			
			 String uid=principal.getName(); 
			 bill=billDao.returnbill(billId);
			 
			 return new ModelAndView("showBill","bill",bill);
			 
			 
			 
		 }
}