import java.util.Scanner;

import trie.StringRadixTreeMap;

/**
 *
 * @author Assar
 */
public class PopularLink {

	private StringRadixTreeMap<Integer> articalNames = new StringRadixTreeMap<>();
	private Scanner scanner2;
	private Wikiartical wa = new Wikiartical();
	private boolean moreArticels = true;
	private String last;
	
	private double z;
	
	PopularLink(){
		last = "";
		z=0;
	}

	public void test(){
		System.out.println(wa.getArticel("https://sv.wikipedia.org/w/index.php?title=Special:Alla_sidor"));
	
	
	}

	public void getAllArticels() {
		String htmlText = null;		

		htmlText = wa.getArticel("https://sv.wikipedia.org/w/index.php?title=Special:Alla_sidor");
		readPage(htmlText);	
		
		while (moreArticels) {

			htmlText = wa.getArticel("https://sv.wikipedia.org/w/index.php?title=Special:Alla_sidor&from="
					+ last);
			System.out.println(last + " " + z);
			readPage(htmlText);
			
		}
	}
	
	private void readPage(String s) {
		scanner2 = new Scanner(s);
		while (scanner2.hasNextLine()) {
			String line = scanner2.nextLine();
			if (line.startsWith("<li class")) {
				if (line.contains("title=\"")) {
					int x = line.indexOf("<a href=\"");
					x=x+15;
					int y = line.indexOf("\"", x);
					last = line.substring(x, y);
					System.out.println(last);
					if (addwikiArtical(last) == false) {
						moreArticels= false;
					}
				}
			}
		}
	}
	private boolean addwikiArtical(String s){
		if(articalNames.putIfAbsent(s, 1)==null){
			return false;
		}
		z++;
		return true;
		
	}
}
