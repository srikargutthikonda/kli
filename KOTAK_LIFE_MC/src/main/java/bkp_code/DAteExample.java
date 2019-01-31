package bkp_code;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DAteExample {
public static void main(String[] args) {
	String sDate1="2019-01-14";  
	String toDate="2019-01-14"; 
    
	try {
		/* DateFormat srcDf = new SimpleDateFormat("YYYY-MM-DD");
		 Date date = srcDf.parse(sDate1.trim());
		 
		  DateFormat destDf = new SimpleDateFormat("dd-MM-yy");
		  sDate1 = destDf.format(date);
		 System.out.println(sDate1);
		 
		 DateFormat endDf = new SimpleDateFormat("YYYY-MM-DD");
		 Date endDateF = endDf.parse(endDate.trim());
		 
		  DateFormat endFormat = new SimpleDateFormat("dd-MM-yy");
		  toDate = endFormat.format(endDateF);
		 System.out.println(toDate);
		 */
		
		
		SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfmt2= new SimpleDateFormat("dd-MM-yy");
		java.util.Date dDate = sdfmt1.parse( sDate1 );
		String strOutput = sdfmt2.format( dDate );
		
		
		 System.out.println("Dates between "+strOutput+" "+toDate);
		 
		 
	    System.out.println("#####################################################");
	 
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
