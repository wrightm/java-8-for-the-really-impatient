package com.wrightm.tutorials.java8.newdateandtime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatting {
	public static void main(String[] args){
		ZonedDateTime apollo11Launch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, 
		         ZoneId.of("America/New_York"));
		
		String formatted = DateTimeFormatter.ISO_DATE_TIME.format(apollo11Launch);
		// 1969-07-16T09:32:00-05:00[America/New_York]
	    System.out.println(formatted);
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	    formatted = formatter.format(apollo11Launch);
	    // July 16, 1969 9:32:00 AM EDT
	    System.out.println(formatted);
	    formatted = formatter.withLocale(Locale.FRENCH).format(apollo11Launch);
	    // 16 juillet 1969 09:32:00 EDT
	    System.out.println(formatted);
	    
	    formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
	    formatted = formatter.format(apollo11Launch);
	    System.out.println(formatted);

	    LocalDate churchsBirthday = LocalDate.parse("1903-06-14");
	    System.out.println("churchsBirthday: " + churchsBirthday);
	    apollo11Launch = ZonedDateTime.parse("1969-07-16 03:32:00-0400",
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
	    System.out.println("apollo11launch: " + apollo11Launch);
	    
	    
	    
	}
}
