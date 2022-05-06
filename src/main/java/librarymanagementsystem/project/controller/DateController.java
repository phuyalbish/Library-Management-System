package librarymanagementsystem.project.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateController {
	public boolean isDateGreater(String inputDate) throws Exception
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Long millis = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(millis);
		String curDate = df.format(currentDate);
		
		Date d1 = df.parse(inputDate);
		Date d2 = df.parse(curDate);
		
		if(d1.compareTo(d2) > 0) {
	         return true;
	      } else
	    	 return false;
	      } 
}
