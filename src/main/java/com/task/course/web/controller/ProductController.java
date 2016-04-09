package com.task.course.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.course.meta.Content;
import com.task.course.service.ContentService;

@Controller
public class ProductController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/public")
	private String Public(){
		return "public";
	}
	
	@RequestMapping("/publicSubmit")
	private String PublicSubmit(@Param("title")String title,@Param("image")String image,@Param("detail") String detail,@Param("price") Integer price,@Param("summary") String summary,Model map,HttpSession session){
		
			Content content = new Content();
			content.setTitle(title);
			content.setImage(image);
			content.setPrice(price);
			content.setSummary(summary);
			content.setDetail(detail);
			contentService.addConten(content);
			System.out.println("add content id:"+content.getId()+",title:"+content.getTitle());
			map.addAttribute("product", content);
		
		return "publicSubmit";
	}
	@RequestMapping("/edit")
	private String PublicProductedit(@Param("id") Integer id,Model map,HttpSession session){
		System.out.println("Param id:"+id);
		
		Content content = new Content();
		content = contentService.getSingleConten(id);
		if (content == null){
			System.out.println("content null");
		}
		System.out.println("edit content id:"+content.getId()+",title:"+content.getTitle());
		map.addAttribute("product", contentService.getSingleConten(id));
		return "edit";
	}
	@RequestMapping("/editSubmit")
	private String PublicProducteditSubmit(@Param("title")String title,@Param("id") Integer id,@Param("image")String image,@Param("detail") String detail,@Param("price") Integer price,@Param("summary") String summary,Model map,HttpSession session){
		Content content = new Content();
		content.setId(id);
		content.setTitle(title);
		content.setImage(image);
		content.setPrice(price);
		content.setSummary(summary);
		content.setDetail(detail);
		contentService.updateContent(content);
		System.out.println("editSubmit content id:"+content.getId()+",title:"+content.getTitle());
		map.addAttribute("product", content);
		return "editSubmit";
	}

}
