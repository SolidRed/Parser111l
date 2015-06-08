import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Rexep {

	 public static final String TEXT = "3 минуты назад"; 
	 
	    public static void main(String[] args){ 
	    	char a = TEXT.charAt(0);
	    	System.out.println(a);
	    	
	    	int b = Character.getNumericValue(a); // assign first char of string
	    	
	    	   	
	    	    	
	    	LocalDateTime dateTime2 = LocalDateTime.now();
	    	System.out.println(dateTime2);
	    	LocalDateTime dateTimeModified = dateTime2.minusMinutes(b);
	    	System.out.println(dateTimeModified);
	    	
	    	LocalTime time = LocalTime.now();
	    	System.out.println(time);
	    	LocalTime timeModified = time.minusMinutes(b);
	    	System.out.println(timeModified);
	    	
	    	
	    	Calendar c = new GregorianCalendar();
	    	System.out.println(c.getTime());
	 
	    	
	    	
	 
	     } 

}
