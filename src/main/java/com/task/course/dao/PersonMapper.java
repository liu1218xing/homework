package com.task.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.task.course.meta.Person;

public interface PersonMapper {
	@Select("SELECT * FROM Person")
	public List<Person> getAllPerson();
	
	@Select("SELECT * FROM Person WHERE userName=#{userName} AND password=#{password}")
	public Person login(@Param("userName") String userName, @Param("password") String password);
	
	@Select("SELECT * FROM Person WHERE userName=#{userName}")
	public Person getPerson(String userName);
}
