package com.task.course.service;

import java.util.List;

import com.task.course.meta.Content;

public interface ContentService {
	public Content getSingleConten(int id);
	public List<Content> getAllConten();
	public void addConten(Content content);
	public void updateContent(Content content);
	public void deleteContent(int id);
}
