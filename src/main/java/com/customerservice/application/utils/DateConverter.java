/**
 * 
 */
package com.customerservice.application.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Ojo Gideon .O 26th January, 2022 Date utilities
 *
 */
@Component
public class DateConverter {
	
    //Method to get current date
	public String getCurrentDate() {
		System.out.println("Getting Current Date");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    
	    return formatter.format(date);
	}
}
