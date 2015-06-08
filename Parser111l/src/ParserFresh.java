import java.io.IOException;
import java.time.LocalTime;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParserFresh {

	public static void main(String[] args) 
	{
		
		try {
		Document doc = Jsoup.connect("http://l2on.net/?c=market&a=item&id=6660").get();
		
				
		
		
		Element values = doc.select("table[class=tablesorter] tbody tr").first();
		
		Elements fresh = doc.select("tr[class*=fresh]");
		
				
		Iterator<Element> iteFreshNick = fresh.select("td.nick").iterator();
		Iterator<Element> iteOrder = fresh.select("td[order]").iterator();
		Iterator<Element> iteTown = fresh.select("td.town").iterator();
		
		while(iteFreshNick.hasNext()){
			String a = iteFreshNick.next().text(); //Nick
			String b = iteOrder.next().text(); // Price
			String c = iteOrder.next().text(); // Mod
			String d = iteOrder.next().text(); // Time
			String e = iteTown.next().text(); // Town
			
			
		System.out.println(a + " | " + b + " | " + c + " | " + d + " | " + e);
		}
	
		
			
		} catch(IOException e){}
	}

}
