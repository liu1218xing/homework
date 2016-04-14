package com.task.course.service;

import java.util.List;

import com.task.course.meta.ProductList;

public interface ProductService {
	public List<ProductList> getAllProductList()  ;
	public ProductList getProductList(int contentId ,int userId)  throws Exception;
	public ProductList getProduct(int contentId )  throws Exception;
	public List<ProductList> getProductList(int userId)  ;
}
