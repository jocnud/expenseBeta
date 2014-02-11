package com.shahbaz.blog.springmvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class App {

	ArrayList<Expense> expenseList = null;

	@RequestMapping(value = "/rest/expense", method = RequestMethod.GET)
	@ResponseBody
	public ExpenseDay printWelcome(ModelMap model) {

		System.out.println("Controler ");

		String expenseFilePath = Util.intializeProject();

		Gson gson = new Gson();

		ExpenseDay expenseDay = new ExpenseDay();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					expenseFilePath));

			String fileContent = new Scanner(br).useDelimiter("\\Z").next();

			System.out.println(fileContent);
			
			expenseList = new ArrayList<Expense>();

			String singleRecordArr[] = fileContent.split("\n");

			for (String s : singleRecordArr) {
				System.out.println(s + "\n\n\n");
				Expense expense = gson.fromJson(s, Expense.class);
				expenseList.add(expense);
			}

			expenseDay.setListExpense(expenseList);

		} catch (Exception e) {
			System.out.println(e);
		}

		return expenseDay;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String display(ModelMap model) {

		model.addAttribute("url", "ass");
		return "hello";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ExpenseDay findExpense(ModelMap model) {

		
		
		RestTemplate restTemplate = new RestTemplate();
		ExpenseDay expenseDay = restTemplate.getForObject(
				"http://localhost:8080/springmvc/rest/expense",
				ExpenseDay.class);
		System.out.println(" inside find exp ");

		
		
		Expense e = expenseDay.getListExpense().get(0);
		String str="[ { y : 'Home', a : 100}, { y : 'Ciggrate', a : 75, b : 65 } ]";
		model.addAttribute("test1", str+"Helo there ");
		return expenseDay;

	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@RequestMapping(value = "findname", method = RequestMethod.GET)
	@ResponseBody
	public ResTApiSample resTApiSample(
			@RequestParam(value = "firstName", required = false, defaultValue = "Hello Anonymous") String firstName,
			@RequestParam(value = "lastName", required = false, defaultValue = " :)") String lastName) {
		System.out.println("Trying to return");

		ResTApiSample r = new ResTApiSample(firstName, lastName);
		return r;
	}
}
