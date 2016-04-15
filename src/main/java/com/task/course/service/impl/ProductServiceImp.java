package com.task.course.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.course.dao.ContentMapper;
import com.task.course.dao.TrxMapper;
import com.task.course.meta.Content;
import com.task.course.meta.ProductList;
import com.task.course.meta.Trx;
import com.task.course.service.BuyListService;
import com.task.course.service.ProductService;
@Service("ProductService")
public class ProductServiceImp implements ProductService {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private BuyListService buyListService;
	
	@Override
	public List<ProductList> getProductList(int userId) {
		// TODO Auto-generated method stub
		List<Content> contentList = contentMapper.getAllConten();
		ArrayList<ProductList> productList = new ArrayList<ProductList>();
		for(Content content : contentList){
			ProductList product = new ProductList();
			product.setId(content.getId());
			product.setTitle(content.getTitle());
			product.setImage(content.getImage());
			product.setPrice(content.getPrice());
			int countSell = buyListService.getSellCountentCount(content.getId());
			if (countSell > 0){
				product.setSell(true);
			}else{
				product.setSell(false);
			}
			int Buy = buyListService.getBuyCountentCount(content.getId(), userId);
			if (Buy>0){
				product.setBuy(true);
			}else{
				product.setBuy(false);
			}
			productList.add(product);
		}
		return productList;
	}

	@Override
	public ProductList getProductList(int contentId,int userId) throws Exception{
		// TODO Auto-generated method stub
		Content content = new Content();
		content = contentMapper.getSingleConten(contentId);
		ProductList product = new ProductList();
		product.setId(content.getId());
		product.setTitle(content.getTitle());
		product.setImage(content.getImage());
		product.setPrice(content.getPrice());
		product.setSummary(content.getSummary());
		product.setDetail(new String(content.getDetail(),"UTF-8"));
		System.out.println("utf detail:"+new String(content.getDetail(),"UTF-8") +",title:"+content.getTitle()+",summay:"+content.getSummary());
		Trx trx = new Trx();
		int count= buyListService.getSellCountentCount(content.getId());
		if (count >0){
			product.setSell(true);
		}else{
			product.setSell(false);
		}
		Trx CurrTrxContent = new Trx();
		CurrTrxContent = buyListService.getCurrPersonIsBuyContent(content.getId(), userId);
		
		if (CurrTrxContent != null){
			product.setBuy(true);
			product.setBuyPrice(CurrTrxContent.getPrice());
		}else{
			product.setBuy(false);
			product.setBuyPrice(0);
		}
		System.out.println("getProductList id:"+content.getId()+",issell:"+product.getisSell());
		return product;
	}

	@Override
	public List<ProductList> getAllProductList() {
		// TODO Auto-generated method stub
		List<Content> contentList = contentMapper.getAllConten();
		ArrayList<ProductList> productList = new ArrayList<ProductList>();
		for(Content content : contentList){
			ProductList product = new ProductList();
			product.setId(content.getId());
			product.setTitle(content.getTitle());
			product.setImage(content.getImage());
			product.setPrice(content.getPrice());
			
			int count= buyListService.getSellCountentCount(content.getId());
			
			if (count > 0){
				product.setSell(true);
			}else{
				product.setSell(false);
			}
			System.out.println("getAllProductList id:"+content.getId()+",issell:"+product.getisSell());
			product.setBuy(false);
		
			productList.add(product);
		}
		return productList;
	}

	@Override
	public ProductList getProduct(int contentId) throws Exception {
		// TODO Auto-generated method stub
		Content content = new Content();
		content = contentMapper.getSingleConten(contentId);
		ProductList product = new ProductList();
		product.setId(content.getId());
		product.setTitle(content.getTitle());
		product.setImage(content.getImage());
		product.setPrice(content.getPrice());
		product.setSummary(content.getSummary());
		product.setDetail(new String(content.getDetail(),"UTF-8"));
		Trx trx = new Trx();
		int count= buyListService.getSellCountentCount(content.getId());
		if (count > 0 ){
			product.setSell(true);
		}else{
			product.setSell(false);
		}
		product.setBuy(false);
		product.setBuyPrice(content.getPrice());
		
		return product;
	}

}
