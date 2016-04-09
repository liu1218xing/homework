package com.task.course.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {
	@Autowired
	private Model map;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 从session中获取登录者实体  
        Object obj = request.getSession().getAttribute("User");  
        if (obj == null) {  
       	 filterChain.doFilter(request, response);  
        } else {  
            // 如果session中存在登录者实体，则加入User属性继续  
        	map.addAttribute("user", obj);
        	System.out.println("obj:"+obj);
            filterChain.doFilter(request, response);  
        }
        
        
	}

}
