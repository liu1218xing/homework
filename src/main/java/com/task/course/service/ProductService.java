package com.task.course.service;

import java.util.List;

import com.task.course.meta.ProductList;

public interface ProductService {
	public List<ProductList> getAllProductList();
	public ProductList getProductList(int contentId ,int userId);
	public ProductList getProduct(int contentId );
	public List<ProductList> getProductList(int userId);
}
