package com.task.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.course.dao.ContentMapper;
import com.task.course.dao.TrxMapper;
import com.task.course.meta.Content;
import com.task.course.meta.ProductList;
import com.task.course.meta.Trx;
import com.task.course.service.ProductService;
@Service("ProductService")
public class ProductServiceImp implements ProductService {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	
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
			List<Trx> contentlist= trxMapper.getpersonTrx(content.getId());
			if (contentlist != null){
				product.setSell(true);
			}else{
				product.setSell(false);
			}
			Trx CurrTrxContent = new Trx();
			CurrTrxContent = trxMapper.getCurrPersonIsBuyTrx(content.getId(), userId);
			if (CurrTrxContent != null){
				product.setBuy(true);
			}else{
				product.setBuy(false);
			}
			productList.add(product);
		}
		return productList;
	}

	@Override
	public ProductList getProductList(int contentId,int userId) {
		// TODO Auto-generated method stub
		Content content = new Content();
		content = contentMapper.getSingleConten(contentId);
		ProductList product = new ProductList();
		product.setId(content.getId());
		product.setTitle(content.getTitle());
		product.setImage(content.getImage());
		product.setPrice(content.getPrice());
		product.setSummary(content.getSummary());
		product.setDetail(content.getDetail());
		Trx trx = new Trx();
		List<Trx> contentlist= trxMapper.getpersonTrx(content.getId());
		if (contentlist != null){
			product.setSell(true);
		}else{
			product.setSell(false);
		}
		Trx CurrTrxContent = new Trx();
		CurrTrxContent = trxMapper.getCurrPersonIsBuyTrx(content.getId(), userId);
		
		if (CurrTrxContent != null){
			product.setBuy(true);
			product.setBuyPrice(CurrTrxContent.getPrice());
		}else{
			product.setBuy(false);
			product.setBuyPrice(0);
		}
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
			List<Trx> contentlist= trxMapper.getpersonTrx(content.getId());
			if (contentlist != null){
				product.setSell(true);
			}else{
				product.setSell(false);
			}
			product.setBuy(false);
		
			productList.add(product);
		}
		return productList;
	}

	@Override
	public ProductList getProduct(int contentId) {
		// TODO Auto-generated method stub
		Content content = new Content();
		content = contentMapper.getSingleConten(contentId);
		ProductList product = new ProductList();
		product.setId(content.getId());
		product.setTitle(content.getTitle());
		product.setImage(content.getImage());
		product.setPrice(content.getPrice());
		product.setSummary(content.getSummary());
		product.setDetail(content.getDetail());
		Trx trx = new Trx();
		List<Trx> contentlist= trxMapper.getpersonTrx(content.getId());
		if (contentlist != null){
			product.setSell(true);
		}else{
			product.setSell(false);
		}
		product.setBuy(false);
		product.setBuyPrice(content.getPrice());
		
		return product;
	}

}
