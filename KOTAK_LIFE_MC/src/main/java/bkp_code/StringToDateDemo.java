package bkp_code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class StringToDateDemo{
   public static void main(String args[])
   {
       String testDateString = "02/04/2014";
       String testDateString2 = "02-04-2014 23:37:50";
       String testDateString3 = "02-Apr-2014";
       String testDateString4 = "04 02, 2014";
       String testDateString5 = "Thu, Apr 02 2014";
       String testDateString6 = "Thu, Apr 02 2014 23:37:50";
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
       DateFormat df4 = new SimpleDateFormat("MM dd, yyyy");
       DateFormat df5 = new SimpleDateFormat("E, MMM dd yyyy");
       DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
       try
       {
           //format() method Formats a Date into a date/time string. 
           Date d1 = df.parse(testDateString);
           System.out.println("Date: " + d1);
           System.out.println("Date in dd/MM/yyyy format is: "+df.format(d1));

           Date d2 = df2.parse(testDateString2);
           System.out.println("Date: " + d2);
           System.out.println("Date in dd-MM-yyyy HH:mm:ss format is: "+df2.format(d2));

           Date d3 = df3.parse(testDateString3);
           System.out.println("Date: " + d3);
           System.out.println("Date in dd-MMM-yyyy format is: "+df3.format(d3));

           Date d4 = df4.parse(testDateString4);
           System.out.println("Date: " + d4);
           System.out.println("Date in MM dd, yyyy format is: "+df4.format(d4));

           Date d5 = df5.parse(testDateString5);
           System.out.println("Date: " + d5);
           System.out.println("Date in E, MMM dd yyyy format is: "+df5.format(d5));

           Date d6 = df6.parse(testDateString6);
           System.out.println("Date: " + d6);
           System.out.println("Date in E, E, MMM dd yyyy HH:mm:ss format is: "+df6.format(d6));

       }
       catch (Exception ex ){
          System.out.println(ex);
       }
   }
}

