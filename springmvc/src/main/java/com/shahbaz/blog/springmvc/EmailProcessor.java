package com.shahbaz.blog.springmvc;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.google.gson.Gson;

public class EmailProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		boolean isEmailTodays = true;

		System.out.println(" Inside the processor ");
		try {

			File expenseFile = new File("/WEB-INF/expense.txt");

			Message message = exchange.getIn();

			System.out.println(message.getHeader("subject"));
			System.out.println(message.getHeader("from"));
			System.out.println(message.getHeader("to"));
			System.out.println(message.getHeader("sentDate"));
			System.out.println(message.getHeader("receivedDate"));

			ExpenseEmail expenseEmail = new ExpenseEmail();
			expenseEmail.setFrom((String) message.getHeader("from"));
			expenseEmail.setSubject((String) message.getHeader("subject"));
			expenseEmail.setReceivedDate((String) message
					.getHeader("receivedDate"));
			expenseEmail.setSentDate((String) message.getHeader("sentDate"));

			String subjectData[] = expenseEmail.getSubject().split("#");

			ArrayList<Expense> listExpense = new ArrayList<Expense>();

			for (String s : subjectData) {
				Expense expense = new Expense();
				expense.setCategory(s.split(":")[0]);
				expense.setMoney(Long.parseLong(s.split(":")[1]));
				expense.setSummary(s.split(":")[2]);
				listExpense.add(expense);
			}

			ExpenseDay expenseDay = new ExpenseDay();
			expenseDay.setCurrentDate(new Date());
			expenseDay.setListExpense(listExpense);

			Gson gson = new Gson();
			String data = gson.toJson(expenseDay);
			System.out.println(data);

			FileWriter writer = new FileWriter(expenseFile, true);
			writer.write(data + "\n");
			writer.close();

		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
