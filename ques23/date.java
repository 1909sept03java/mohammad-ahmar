package ques23;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
	public static void main(String[] args) {
		String s = "12/07/1996 11:49:00 AM";
		stringToDate(s);
	}

	public static void stringToDate(String s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		Date newDate = new Date();
		try {
			newDate = dateFormat.parse(s);  //parses string to date format
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(newDate);
	}
}
