package com.task.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.task.course.meta.Content;



public interface ContentMapper {
	@Insert("INSERT INTO content (price,title,image,summary,detail) Value(#{price},#{title},#{image},#{summary},#{detail})")
	@Options(useGeneratedKeys = true,keyProperty="id")
	public void addConten(Content content);
	
	@Select("SELECT * FROM Content WHERE id=#{id}")
	public Content getSingleConten(int id);
	
	@Select("SELECT * FROM Content")
	public List<Content> getAllConten();
	
	@Update("UPDATE Content SET price=#{price},title=#{title},image =#{image},summary=#{summary},detail = #{detail} WHERE id=#{id}")
	public void updateContent(Content content);
	
	@Delete("DELETE Content WHERE id=#{id}")
	public void deleteContent(int id);
}
