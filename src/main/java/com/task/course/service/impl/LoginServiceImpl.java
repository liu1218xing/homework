package com.task.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.task.course.dao.PersonMapper;
import com.task.course.meta.Person;
import com.task.course.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	//依赖注入
	@Autowired
	private PersonMapper personMapper;
//	@Value("")
//	private String 
	@Override
	public boolean personLogin(String userName, String password) {
		// //用户登陆验证，验证失败返回false
		Person user=personMapper.login(userName, password);
		System.out.println("personLogin:"+"userName:"+userName+",password:"+password+",user:"+user);
		if ( user== null) {
			return false;
		} else {
			return true;

		}
	}
	@Override
	public Person getPerson(String userName) {
		// TODO Auto-generated method stub
		return personMapper.getPerson(userName);
	}

}
