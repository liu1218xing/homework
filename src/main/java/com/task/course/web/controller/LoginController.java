package com.task.course.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.task.course.meta.Person;
import com.task.course.meta.ProductList;
import com.task.course.meta.User;
import com.task.course.service.LoginService;
import com.task.course.service.ProductService;
import com.task.course.util.JsonUtils;

@Controller
public class LoginController {

	@Autowired 
	private LoginService loginService;
	@Autowired ProductService productService;
	@RequestMapping("/")
	public String showIndex(Model map,HttpSession session){
		if(session.getAttribute("user")!=null){
//			map.addAttribute("user", session.getAttribute("user"));
			User user =new User();
			user = (User) session.getAttribute("user");
			System.out.println("index user:"+user.getId()+",userName:"+user.getUsername());
			map.addAttribute("productList",productService.getAllProductList(user.getId()));
			List<ProductList> productList = productService.getAllProductList(user.getId());
			for(ProductList product :productList){
				System.out.println(product.getId()+",title:"+product.getTitle()+",image:"+product.getImage()+",price:"+product.getPrice()+",isBuy:"+product.getisBuy()+",isSell:"+product.getisSell());
			}
		}
		System.out.println("hello index!");
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		System.out.println("hello spring Login!");
		return "login";
	}
	@RequestMapping("/logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/apitest/{userId}")
	public void spring(@PathVariable("userId") String userId, @RequestParam("msg") String msg,
			@RequestHeader("host") String host, Writer writer) throws IOException {
		writer.write("userId=" + userId + ", msg=" + msg + ", hostHeader=" + host);
		
	}
	
	
	

}
