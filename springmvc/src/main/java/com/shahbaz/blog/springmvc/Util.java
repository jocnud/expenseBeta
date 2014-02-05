package com.shahbaz.blog.springmvc;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));

		String currentDirectory = System.getProperty("user.dir");
		String folderName = "expFolder";
		System.out.println(File.separator);
		String workingDirectory = currentDirectory + File.separator
				+ folderName;

		File folder = new File(workingDirectory);
		if (!folder.exists()) {
			if (folder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

		File file = new File(folder.getAbsolutePath() + File.separator
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

	/**
	 * Compare date if date is same return true else false
	 * 
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
