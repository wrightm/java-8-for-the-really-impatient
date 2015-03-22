package com.wrightm.tutorials.java8.newdateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDates {
	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		System.out.println("today: "+ today);
		
		LocalDate mikesBirthday = LocalDate.of(1986, 10, 01);
		mikesBirthday = LocalDate.of(1986, Month.OCTOBER, 1);
		System.out.println("Mikes Birthday: "+ mikesBirthday);
		
		LocalDate programmersDay = LocalDate.of(2014, 1, 1).plusDays(255);
        // September 13, but in a leap year it would be September 12
		System.out.println("programmersDay: " + programmersDay);
		
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		LocalDate christmas = LocalDate.of(2014, Month.DECEMBER, 25);
	
		System.out.println("Until christmas: " + independenceDay.until(christmas));
		System.out.println("Until christmas: " + independenceDay.until(christmas, ChronoUnit.DAYS));
	
		System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
		System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));
	
		DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
		System.out.println("startOfLastMillennium: " + startOfLastMillennium);
		System.out.println(startOfLastMillennium.getValue());
		System.out.println(DayOfWeek.SATURDAY.plus(3));
	}
}
