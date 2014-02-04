package com.shahbaz.blog.springmvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;


public class Util {

	public static void main(String[] args) {

		System.out.println(compareDate(stringToDate("dd MMM, yyyy HH:mm:ss a",
				"5 Feb, 2014 8:04:44 PM")));

	}

	/**
	 * Compare date if date is same return true else false
	 * @param sent
	 * @return
	 */
	public static boolean compareDate(Date sent) {

		Date date2 = new Date();

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(sent);
		cal2.setTime(date2);

		System.out.println(cal1.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal2.get(Calendar.DAY_OF_MONTH));
		return cal1.get(Calendar.DAY_OF_MONTH) == cal2
				.get(Calendar.DAY_OF_MONTH) ? true : false;

	}

	public static Date stringToDate(String dateFormat, String dateInString) {

		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

		try {
			Date date = formatter.parse(dateInString);
			return date;

		} catch (ParseException e) {
			System.out.println(e);
			return null;
		}
	}

}
