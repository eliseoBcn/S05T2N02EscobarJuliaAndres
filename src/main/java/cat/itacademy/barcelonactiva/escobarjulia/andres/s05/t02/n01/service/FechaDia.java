package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class FechaDia {

	public FechaDia() {
		// TODO Auto-generated constructor stub
	}

	public Date  getFechadia(){
		
 	   
 	    LocalDateTime myDateObj = LocalDateTime.now();
 	    System.out.println("Before formatting: " + myDateObj);
 	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-dd-MM");
 	    String formattedDate = myDateObj.format(myFormatObj);

 	    return new Date();
	}
	
	
	
}
