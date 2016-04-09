package com.task.course.service;

import java.util.List;

import com.task.course.meta.BuyList;
import com.task.course.meta.Trx;



public interface BuyListService {
	public List<BuyList> getbuyList(int userId);
	public void buyTtx(int contentId ,int userId);
}
