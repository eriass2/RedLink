import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Wikiartical {
	
	private Scanner scanner3;
	private URLConnection yc;
	
	/**
	 * Denna har som syfte att ta emot en url och sedan retunera motvarande html kod på den sidan till en string
	 * @param s
	 * @return
	 */

	public String getArticel(String s)  throws Exception{
		URL url = getURL(s);
		System.out.println(url);
		checConnection(url);
		String htmlText = "1";
		try {
			scanner3 = new Scanner(url.openStream(), "UTF-8");
			htmlText = scanner3.useDelimiter("\\A").next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(htmlText==null){
			throw new IOException("Notning");
		}
		return htmlText;
	}
	
	private URL getURL(String s) {
		URL url = null;
		try {
			url = new URL(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;

	}

	private boolean checConnection(URL url) {
		
		try {
			yc = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Thread.sleep(1000); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.out.println("false");
			return false;
		}

		return true;

	}

}
