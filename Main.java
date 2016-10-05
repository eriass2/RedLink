import java.sql.Timestamp;
import java.util.Scanner;

import trie.StringRadixTreeMap;

public class Main {

	private StringRadixTreeMap<Integer> catagory = new StringRadixTreeMap<>();
	private Scanner scanner2;
	private Wikiartical wa = new Wikiartical();

	public Main() {
		// hämta artikel
		//test();
		getAllArticels();

	}
	
	public void test(){
		System.out.println(wa.getArticel("https://sv.wikipedia.org/w/index.php?title=Special:Alla_sidor&from=Acradenia zierioides"));
	
	
	}

	public void getAllArticels() {
		String last = null, htmlText = null;
		double z = 0;
		boolean moreArticels = true;

		htmlText = wa.getArticel("https://sv.wikipedia.org/wiki/Special:Alla_sidor?from=&to=&namespace=0");
		scanner2 = new Scanner(htmlText);
		while (scanner2.hasNextLine()) {

			String line = scanner2.nextLine();
			if (line.startsWith("<li class")) {
				if (line.contains("title=\"")) {
					int x = line.indexOf("/wiki/");
					int s = line.indexOf("\">", x);
					String p = line.substring(x + 6, s);
					last = p;
					System.out.println(p);
				}
			}
		}

		while (moreArticels) {

			htmlText = wa.getArticel("https://sv.wikipedia.org/w/index.php?title=Special:Alla_sidor&from="
					+ last.replaceAll(" ", "%20"));

			scanner2 = new Scanner(htmlText);
			while (scanner2.hasNextLine()) {

				String line = scanner2.nextLine();
				if (line.startsWith("<li class")) {
					if (line.contains("title=\"")) {
						int x = line.indexOf("title=\"");
						int s = line.indexOf("\">", x);
						String p = line.substring(x + 7, s);
						if (p.equals(last)) {
							moreArticels = false;
						} else {
							last = p;
						}
						z++;
					}
				}
			}
			System.out.println(z + " " + last);
		}

	}

	public static void main(String[] args) {
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		new Main();

		System.out.println(new Timestamp(date.getTime()));
	}

}
