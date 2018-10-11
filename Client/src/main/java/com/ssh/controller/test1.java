package com.ssh.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test1 {
	public static void main(String[] args) throws ParseException {
	String printtime = "2018-03-29 06:01 下午";
//	Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm aa",Locale.CHINA).parse(printtime); 
//	  String now = new SimpleDateFormat("MM/dd/yyyy hh:mm aa",Locale.ENGLISH).format(date);
//	  System.out.println(now);
		/*String start = "2018-03-01";
		String end = "2018-03-08";
		DateFormat in = new SimpleDateFormat("yyyy-mm-dd");
		Date dateStart =  in.parse(start);
		Date dateEnd =  in.parse(end);	
		long days = dateEnd.getTime() + dateStart.getTime();
		long day = (days / (1000 * 60 * 60 * 24)); 
		System.out.println(day);*/
	BigDecimal tax = new BigDecimal(10.12222)
            .setScale(2, BigDecimal.ROUND_DOWN);
          
          BigDecimal room = new BigDecimal(10.12222)
            .setScale(2, BigDecimal.ROUND_DOWN);
          BigDecimal less = new BigDecimal(0).
  	             setScale(2, BigDecimal.ROUND_DOWN);
          less = tax.add(room);
          System.out.println(less);
	}
}
