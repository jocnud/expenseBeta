package com.shahbaz.blog.springmvc;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class ExpenseDay {

	public Date currentDate;
	
	public ArrayList<Expense> listExpense;




	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public ArrayList<Expense> getListExpense() {
		return listExpense;
	}

	public void setListExpense(ArrayList<Expense> listExpense) {
		this.listExpense = listExpense;
	}

}
