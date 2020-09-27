import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class webscrapping {
	public static void main(String args[]) throws IOException
	{
		org.jsoup.nodes.Document doc = null;

		String s="space";
		try 
		{
			doc = Jsoup.connect("https://google.com/search?q=" +URLEncoder.encode(s ,"UTF-8") ).get();
			System.out.println("[+] "+doc.title());
			System.out.println("=======================================================================");
			Elements links = doc.select("cite");
			for(Element link : links)
			{

				if(link.text().contains("..."))
					continue;
				else
				{
					String str = link.text().replaceAll(" › ", "/");
					System.out.println(str);
				}
			}
		}
		finally
		{
			System.out.println("===========================================================================");
		}
	}
}
