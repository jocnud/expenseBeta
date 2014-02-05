package com.shahbaz.blog.springmvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class App {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		System.out.println("Controler ");

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"/WEB-INF/expense.txt"));

			// convert the json string back to object
			ExpenseDay obj = gson.fromJson(br, ExpenseDay.class);
			
			System.out.println("1------------  "+obj.getCurrentDate());
			System.out.println("2------------  "+obj.getListExpense().get(0).getCategory());
			
			
			

			System.out.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "hello";

	}

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
