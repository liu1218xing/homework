package com.task.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.course.meta.Person;
import com.task.course.meta.User;
import com.task.course.service.BuyListService;
import com.task.course.service.ContentService;
import com.task.course.service.LoginService;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired 
	private LoginService loginService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private BuyListService buyListService;
	@RequestMapping("/login")
	public String login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password, ModelMap map,HttpSession session,HttpServletResponse resp,HttpServletRequest request)
			throws IOException {
		boolean result =  loginService.personLogin(userName, password);
		System.out.println("name:"+userName+",pwd:"+password+",result:"+result);
		if(result==true){
			int code =resp.getStatus();
			map.addAttribute("code", code);
			map.addAttribute("message", "帐号和密码验证成功");
			map.addAttribute("result",result);
			Person person= loginService.getPerson(userName);
			User user = new User();
			user.setId(person.getId());
			user.setUsername(person.getUserName());
			user.setUsertype(person.getUserType());
			user.setNickname(person.getNickName());
			System.out.println("user:"+user.getUsername()+",type:"+user.getUsertype());
//			String userjson = "{"+"user"+":[" +JsonUtils.objectToJson(user)+"]}";
//			String userjson = JsonUtils.objectToJson(user);
			session.setAttribute("user", user);
			Object obj = session.getAttribute("user");
			System.out.println("obj:"+obj);
			System.out.println("user:"+user.toString());
		}else{
			int code =resp.getStatus();
			map.addAttribute("code", code);
			map.addAttribute("message", "帐号或密码验错误");
			map.addAttribute("result",result);
		}
		System.out.println(map);
		return "json";
	}
	@RequestMapping("/delete")
	public String ProductDelete(@RequestParam("id") Integer id, 
			@RequestParam("password") String password, ModelMap map,HttpSession session,HttpServletResponse resp,HttpServletRequest request)
			throws IOException {
		
		contentService.deleteContent(id);
		if (resp.getStatus()==200){
			map.addAttribute("code",resp.getStatus());
			map.addAttribute("message","delete ok");
			map.addAttribute("result",true);
		}else{
			map.addAttribute("code",resp.getStatus());
			map.addAttribute("message","delete faild");
			map.addAttribute("result",false);
		}
		return "json";
	}
	@RequestMapping("/buy")
	public String ProductBuy(@RequestParam("id") Integer id, 
			@RequestParam("password") String password, ModelMap map,HttpSession session,HttpServletResponse resp,HttpServletRequest request)
			throws IOException {
		User user= new User();
		buyListService.buyTtx(id, user.getId());
		if (resp.getStatus()==200){
			map.addAttribute("code",resp.getStatus());
			map.addAttribute("message","buy ok");
			map.addAttribute("result",true);
		}else{
			map.addAttribute("code",resp.getStatus());
			map.addAttribute("message","buy faild");
			map.addAttribute("result",false);
		}
		return "json";
	}
	
	
}
