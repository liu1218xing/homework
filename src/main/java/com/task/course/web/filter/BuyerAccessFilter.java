package com.task.course.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.task.course.meta.User;

public class BuyerAccessFilter extends OncePerRequestFilter {
	private User user;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		if(session!=null){
		user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 0) {
			// 由session判断用户是否已登录
			filterChain.doFilter(request, response);
		} else {
			// 如果用户未登陆，则弹出框提示重新登录
			PrintWriter out = response.getWriter();
			String loginPage = "/login";
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\">");
			builder.append("alert('please login with buyer.');");
			builder.append("window.top.location.href='");
			builder.append(loginPage);
			builder.append("';");
			builder.append("</script>");
			out.print(builder.toString());
		}
		}else{
			filterChain.doFilter(request, response);
		}

	}

}
