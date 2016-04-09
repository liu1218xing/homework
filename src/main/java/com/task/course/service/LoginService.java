package com.task.course.service;

import com.task.course.meta.Person;

public interface LoginService {
	public boolean personLogin(String userName,String password);
	public Person getPerson(String userName);
	
}
