package com.task.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.task.course.meta.Content;
import com.task.course.meta.Trx;

public interface TrxMapper {
	@Insert("INSERT INTO Trx (contentId,personId,price,time) Value(#{contentId},#{personId},#{price},#{time})")
	@Options(useGeneratedKeys = true,keyProperty="id")
	public void addTtx(Trx trx);
	
	@Select("SELECT * FROM Trx WHERE id=#{id}")
	public Trx getSingleTrx(int id);
	
	@Select("SELECT * FROM Trx WHERE personId=#{personId}")
	public List<Trx> getContentTrx(int personId);
	
	@Select("SELECT * FROM Trx WHERE contentId=#{contentId}")
	public List<Trx> getpersonTrx(int contentId);
	
	@Select("SELECT * FROM Trx WHERE contentId=#{contentId} AND personId=#{personId}")
	public Trx getCurrPersonIsBuyTrx(@Param("contentId") int contentId, @Param("personId") int personId);
	
	@Select("SELECT * FROM Trx")
	public List<Trx> getAllTrx();
	
	@Update("UPDATE Trx SET contentId=#{contentId},personId=#{personId},price=#{price},time = #{time}} WHERE id=#{id}")
	public void updateTrx(Trx trx);
}
