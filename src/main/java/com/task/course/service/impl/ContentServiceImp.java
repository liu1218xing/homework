package com.task.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.course.dao.ContentMapper;
import com.task.course.meta.Content;
import com.task.course.service.ContentService;
@Service
public class ContentServiceImp implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	@Override
	public Content getSingleConten(int id) {
		// TODO Auto-generated method stub
		Content content = new Content();
		content = contentMapper.getSingleConten(id);
		return content;
	}

	@Override
	public List<Content> getAllConten() {
		// TODO Auto-generated method stub
		List<Content> content = contentMapper.getAllConten();
		return content;
	}

	@Override
	public void addConten(Content content) {
		// TODO Auto-generated method stub
		contentMapper.addConten(content);
		
	}

	@Override
	public void updateContent(Content content) {
		// TODO Auto-generated method stub
		contentMapper.updateContent(content);
	}

	@Override
	public void deleteContent(int contentId) {
		// TODO Auto-generated method stub
		System.out.println("del id:"+contentId);
		contentMapper.deleteContent(contentId);
		
	}

}
