package com.task.course.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.course.meta.User;
import com.task.course.service.BuyListService;
import com.task.course.service.LoginService;
import com.task.course.service.ProductService;

@Controller
public class ShowController {

	@Autowired 
	ProductService productService;
	@Autowired
	BuyListService buyListService;
	
	@RequestMapping("/show")
	public String show(Model map,HttpSession session,int id) throws Exception{
		User user =new User();
		user = (User) session.getAttribute("user");
		if (user != null){
			map.addAttribute("product",productService.getProductList(id, user.getId()));
		}else
		{
			map.addAttribute("product",productService.getProduct(id));
		}
		
		return "show";
	}
	@RequestMapping("/account")
	public String showAccount(@Param("id")Integer id,Model map,HttpSession session){
		User user =new User();
		user = (User) session.getAttribute("user");
		map.addAttribute("buyList",buyListService.getbuyList(user.getId()));
		return "account";
	}
}
