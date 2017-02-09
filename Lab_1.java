package Lab_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab_1 {
	
	private static double f (int i) {
		double rez = 1;
		if (i == 0)
			return rez = 1;
		else {
		for (int in = i; in != 0; in --) {
			rez = rez * in;
		}
		return rez;
		}
	}

	private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private static DateFormat dF = new SimpleDateFormat("DD");
	private static Date date = new Date();
	private static Scanner sc = new Scanner (System.in);
	private static String name, data, text = dateFormat.format(date), str1 = dF.format(date);
	private static int length = 0, y = 0, day = 0, month = 0, year = 0, days = 0, io = 0, 
			daySystem, monthSystem, yearSystem, index = 0, dayBirthday, monthBirthday, yearBirthday;
	private static double d = 1;
	private static int [] mmonth = new int [12];
	private static int [] in = new int [2];

	public static void main (String [] args) {
		
		mmonth[0] = 31;   //січень
		mmonth[1] = 28;   //лютий
		mmonth[2] = 31;   //березень
		mmonth[3] = 30;   //квітень
		mmonth[4] = 31;   //травень
		mmonth[5] = 30;   //червень
		mmonth[6] = 31;   //липень
		mmonth[7] = 31;   //серпень
		mmonth[8] = 30;   //вересень
		mmonth[9] = 31;   //жовтень
		mmonth[10] = 30;  //листопад
		mmonth[11] = 31;  //грудень
		
		System.out.print("Hello World!" + "\n" + "Please, enter your name: ");
		name = sc.nextLine();
		System.out.println("Hello, " + name + "!");
		length = name.length();
		d = f(length);
		System.out.println("Your name has " + length +" letters. " + length + "! = " + d);
		System.out.print("Please, enter your birth data in format (DD.MM.YYYY): ");
		data = sc.nextLine();
		
		for (int i = 0; i < text.length(); i ++) {
			if (text.charAt(i) == '.') {
				in[y] = i;
				y ++;
			}
		}
		
		daySystem = Integer.parseInt(text.substring(index, in[0]));
		monthSystem = Integer.parseInt(text.substring(in[0] + 1, in[1]));
		yearSystem = Integer.parseInt(text.substring(in[1] + 1, text.length()));
		
		in[0] = 0;
		in[1] = 0;
		y = 0;
		
		for (int i = 0; i < data.length(); i ++) {
			if (data.charAt(i) == '.') {
				in[y] = i;
				y ++;
			}
		}
		
		dayBirthday = Integer.parseInt(data.substring(index, in[0]));
		monthBirthday = Integer.parseInt(data.substring(in[0] + 1, in[1]));
		yearBirthday = Integer.parseInt(data.substring(in[1] + 1, data.length()));
		
		year = yearSystem - yearBirthday;
		if ((monthSystem - monthBirthday) < 0) {
			year = year - 1;
			io = 1;
			month = 12 - monthBirthday + monthSystem;
		}
		else month = monthSystem - monthBirthday;
		
		if ((daySystem - dayBirthday) < 0) {
			month = month - 1;
			day = mmonth[monthBirthday - 1] - dayBirthday + daySystem;
			if (monthBirthday == 1 || monthBirthday == 2) 
				day = day + 1;
		}
		else day = daySystem - dayBirthday;
		
		days = mmonth[monthBirthday - 1] - dayBirthday;
		for (int i = monthBirthday; i < 12; i ++) {
			days = days + mmonth[i];
		}
		
		for (int i = 0; i < year + io; i ++) {
			if (((yearBirthday + i) % 4) == 0) 
				 days = days + 366;
			else days = days + 365;
		}

		days = days + Integer.parseInt(str1) - 365;
				
		System.out.println("Today is " + text + ", you are " + year + " year(s), " + 
		month + " month(s), " + day + " day(s) " + "(" + days + " day[s])" + " old.");
	}
}