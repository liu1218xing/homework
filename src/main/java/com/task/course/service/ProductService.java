package com.task.course.service;

import java.util.List;

import com.task.course.meta.ProductList;

public interface ProductService {
	public List<ProductList> getAllProductList(int userId);
	public ProductList getProductList(int contentId ,int userId);
}
