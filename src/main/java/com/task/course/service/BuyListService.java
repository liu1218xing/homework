package com.task.course.service;

import java.util.List;

import com.task.course.meta.BuyList;
import com.task.course.meta.Trx;



public interface BuyListService {
	public List<BuyList> getbuyList(int personId);
	public void buyTtx(int contentId ,int personId);
	public int getSellCountentCount(int contentId);
	public int getBuyCountentCount(int contentId,int personId);
	public Trx getCurrPersonIsBuyContent(int contentId ,int personId);

}
