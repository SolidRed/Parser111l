import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParserFresh2 {

	public static void main(String[] args) {
		
		
		try {
			
			
			Document doc = Jsoup.connect("http://l2on.net/?c=market&a=item&id=19448").get();
			
			Element title = doc.select("h1").first();
			System.out.println(title.text().toUpperCase());
			
			Elements fresh = doc.select("div#group_sell tr[class*=fresh]");
			
			for (int i = 0; i < fresh.size(); i++){ // � ����� ���������� ���� ��������
			Element fresh0 = fresh.get(i);
			//System.out.println(fresh0);
			System.out.println("---------------------------------------------------------------");
			
			Elements fresh0Nick = fresh0.select("td.nick"); //���
			Iterator<Element> iteOrder = fresh0.select("td[order]").iterator(); // ����� �� ����, ���-�� (��� ���), �������
			Elements fresh0Town = fresh0.select("td.town"); // �����
			
			String a = fresh0Nick.text(); //Nick
			String b = iteOrder.next().text(); // Price
			String c = iteOrder.next().text(); // Mod
			String d = iteOrder.next().text(); // Time
			LocalTime timee;
			
			if(d.contains("���")){
			Integer x = Integer.parseInt(extractDigits(d));
			LocalTime time = LocalTime.now().plusHours(1);
				
			timee = time.minusMinutes(x);
			} 
			else if(d.contains("���")) {
				Integer x = Integer.parseInt(extractDigits(d));
				LocalTime time = LocalTime.now().plusHours(1);
					
				timee = time.minusHours(x);
			} 
			
			else{	
			timee = LocalTime.of(23, 59);
			}
			
			
			
			
			String e = fresh0Town.text(); // Town
			
			DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("hh:mm:ss").toFormatter();
			
			FileWorker.metwrite("D://a.txt", a);
			
			System.out.println(a + " | " + b + " | " + c + " | " + timee.format(formatter) + " | " + e);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static String extractDigits(String src) {
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < src.length(); i++) {
	        char c = src.charAt(i);
	        if (Character.isDigit(c)) {
	            builder.append(c);
	        }
	      }
	    String number = builder.toString();
	    if (number.equals("")){
	    	return "1";
	    }
	    return number;
	}
	
	
	
}
