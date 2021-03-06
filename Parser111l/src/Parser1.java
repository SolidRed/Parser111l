import java.io.IOException;



import java.time.LocalTime;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class Parser1 {

	public static void main(String[] args) 
	{
		
		try {
		Document doc = Jsoup.connect("http://l2on.net/?c=market&a=item&id=6660").get();
		
		Element link = doc.select("a").first();
		Element div = doc.select("td").first(); // <div> </div>
		
		
		/*	String title = doc.title();
		System.out.println(title);
		
		String something = doc.text();
		System.out.println(something);
		
		String linktext = link.text();
		System.out.println(linktext);
		
		String divtext = div.text();
		System.out.println(divtext); 
		
		Elements elems = doc.select("tr a");
			for (Element element : elems) {
				System.out.println(element.text());
		}
		
		
		
		Elements table = doc.select("span.l2item");
		System.out.println(table.text());
			for (Element tables : table) {
				System.out.println(tables.text());
		}
		
		
		Elements count = doc.select("td.right");
		System.out.println(count.text());
			for (Element counts : count) {
				System.out.println(counts.text());
		}
		*/
		
		
		Element tablee = doc.select("td.nick").first();
		Element values = doc.select("table[class=tablesorter] tbody tr").first();
		Element fresh = doc.select("tr[class*=fresh]").first();
		
		System.out.println(fresh.text());
		
		Iterator<Element> ite = values.select("td.right").iterator();
		Iterator<Element> itenick = values.select("td.nick").iterator();
		Iterator<Element> itetime = values.select("td[order]").iterator();
		Iterator<Element> itetown = values.select("td.town").iterator();
		
		
		
		/*while (itetime.hasNext()){
			
		System.out.println(itenick.next().text() + " | " + itetime.next().text() + " | " + itetime.next().text() + " | " + itetime.next().text()+ " | " + itetown.next().text());
			
			System.out.println("");
		}*/
			
		while (itetime.hasNext()){
			String a = itetime.next().text();
			String b = itetime.next().text();
			String c = itetime.next().text(); // time
			
			char minutes = c.charAt(0);
			int minutesago = Character.getNumericValue(minutes);
			LocalTime time = LocalTime.now();
			LocalTime timeago = time.minusMinutes(minutesago);
			
			
			System.out.println(itenick.next().text() + " | " + a + " | " + b + " | " + timeago + " | " + itetown.next().text());
				
				System.out.println("");
			}
		
		
	//	System.out.println(tablee.text() + " | " + values.text());
	//	System.out.println(values.text());
		
		
			
		} catch(IOException e){}
	}

}
