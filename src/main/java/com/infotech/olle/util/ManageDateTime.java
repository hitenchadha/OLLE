package com.infotech.olle.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ManageDateTime {
	private Calendar cal = Calendar.getInstance();
	
	public ManageDateTime() {
		
	}
	
	public String getCurrentDateTime() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		// SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedTime = "";
		
		try {

			Date d = sdf.parse(cal.getTime().toString());
			formattedTime = output.format(d);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formattedTime;
		
		
	}

	public Date getCurrentDateTimedt() {
		return cal.getTime();
	}

	public String get24HrDateTime() {
		cal.setTime(cal.getTime());
		cal.add(Calendar.DATE, 1);	
		
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String formattedTime = "";
		try {
			Date d = sdf.parse(cal.getTime().toString());
			formattedTime = output.format(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formattedTime;
	}
	
	public Date get1YrDateTime() {
		cal.setTime(cal.getTime());
		cal.add(Calendar.DATE, 365);		
		return cal.getTime();
	}
	
	

}
