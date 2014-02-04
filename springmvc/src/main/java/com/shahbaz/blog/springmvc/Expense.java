package com.shahbaz.blog.springmvc;

import java.io.Serializable;

public class Expense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8263046820194353913L;
	
	public String category;
	
	public long money;
	
	public String summary;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	

}
