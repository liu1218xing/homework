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

/**
 * 
 * @author liuxing
 *@Description:api接口类，实现登陆、删除商品、购买商品
 *@datetime 2016年4月15日上午8:42:28
 */
@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired 
	private LoginService loginService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private BuyListService buyListService;
	//登陆接口
	@RequestMapping("/login")
	public String login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password, ModelMap map,HttpSession session,HttpServletResponse resp,HttpServletRequest request)
			throws IOException {
		boolean result =  loginService.personLogin(userName, password);
		System.out.println("name:"+userName+",pwd:"+password+",result:"+result);
		if(result==true){
			int code =resp.getStatus();
			map.addAttribute("code", code);
			map.addAttribute("message", "登录成功");
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
			
			map.addAttribute("code", 204);
			map.addAttribute("message", "登录失败");
			map.addAttribute("result",result);
		}
		System.out.println(map);
		return "json";
	}
	//删除商品接口
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
			map.addAttribute("code",204);
			map.addAttribute("message","delete faild");
			map.addAttribute("result",false);
		}
		return "json";
	}
	//购买接口
	@RequestMapping("/buy")
	public String ProductBuy(@RequestParam("id") Integer id, 
			 ModelMap map,HttpSession session,HttpServletResponse resp,HttpServletRequest request)
			throws IOException {
		
		User user= new User();
		user = (User) session.getAttribute("user");
		System.out.println("buy id:"+id+",userid:"+user.getId());
		buyListService.buyTtx(id, user.getId());
		if (resp.getStatus()==200){
			map.addAttribute("code",resp.getStatus());
			map.addAttribute("message","buy ok");
			map.addAttribute("result",true);
		}else{
			map.addAttribute("code",204);
			map.addAttribute("message","buy faild");
			map.addAttribute("result",false);
		}
		return "json";
	}
	
	
}
