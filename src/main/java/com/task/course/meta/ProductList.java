package com.task.course.meta;

import java.sql.Blob;

public class ProductList {
	private int id;
	private String title;
	private String summary;
	private String detail;
	private String image;
	private int price;
	private int buyPrice;
	private boolean isBuy;
	private boolean isSell;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public boolean getisBuy() {
		return  isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public boolean getisSell() {
		return  isSell;
	}
	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
	
}
