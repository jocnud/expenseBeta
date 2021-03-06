package com.shahbaz.blog.springmvc;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.jolokia.client.J4pClient;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;



public class Util {

	public static void main(String[] args) {
		
		try{

        J4pClient j4pClient = new J4pClient("http://localhost:8080/springmvc/jolokia");
        J4pReadRequest req = new J4pReadRequest("org.apache.camel:type=routes,*","CamelId");
        J4pReadResponse resp = j4pClient.execute(req);
       System.out.println(resp.asJSONObject());
		}catch(Exception e){
			System.out.println(e);
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

	public static String intializeProject() {
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

		return file.getAbsolutePath();
	}

}
