package com.task.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.course.dao.ContentMapper;
import com.task.course.dao.TrxMapper;
import com.task.course.meta.BuyList;
import com.task.course.meta.Content;
import com.task.course.meta.Trx;
import com.task.course.service.BuyListService;
@Service
public class BuyListServiceImpl implements BuyListService {
	
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	@Override
	public List<BuyList> getbuyList(int userId) {
		ArrayList<BuyList> buyList = new ArrayList<BuyList>();
		// TODO Auto-generated method stub
		List<Trx> trxlist =  trxMapper.getContentTrx(userId);
		for(Trx trx:trxlist){
			BuyList buy = new BuyList();
			buy.setId(trx.getContentId());
			buy.setBuyPrice(trx.getPrice());
			buy.setBuyTime(trx.getTime());
			Content content = new Content();
			content = contentMapper.getSingleConten(trx.getContentId());
			buy.setTitle(content.getTitle());
			buy.setImage(content.getImage());
			buyList.add(buy);
		} 
		return buyList;
	}
	@Override
	public void buyTtx(int contentId, int userId) {
		// TODO Auto-generated method stub
		Content content=new Content();
		content = contentMapper.getSingleConten(contentId);
		Trx trx = new Trx();
		long time = System.currentTimeMillis();
		trx.setContentId(contentId);
		trx.setPersonId(userId);
		trx.setPrice(content.getPrice());
		trx.setTime(time);
		trxMapper.addTtx(trx);

	}
	@Override
	public int getSellCountentCount(int id) {
		// TODO Auto-generated method stub

		return trxMapper.getCountCountent(id);
	}
	@Override
	public int getBuyCountentCount(int contentId, int userId) {
		// TODO Auto-generated method stub
		return trxMapper.getCountBuyCountent(contentId,userId);
	}
	@Override
	public Trx getCurrPersonIsBuyContent(int contentId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
