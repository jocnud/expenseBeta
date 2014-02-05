package com.shahbaz.blog.springmvc;

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

	File folder = null;

	File file = null;

	@Override
	public void process(Exchange exchange) throws Exception {

		boolean isEmailTodays = true;

		intializeProject();

		System.out.println(" Inside the processor ");
		try {



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

			FileWriter writer = new FileWriter(file, true);
			writer.write(data + "\n");
			writer.close();

		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void intializeProject() {
		System.out.println(System.getProperty("user.dir"));

		String currentDirectory = System.getProperty("user.dir");
		String folderName = "expFolder";
		System.out.println(File.separator);
		String workingDirectory = currentDirectory + File.separator
				+ folderName;

		folder = new File(workingDirectory);
		if (!folder.exists()) {
			if (folder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

		file = new File(folder.getAbsolutePath() + File.separator
				+ "expense.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
