import java.sql.Timestamp;
import java.util.Scanner;

import trie.StringRadixTreeMap;

public class Main {
	
	private PopularLink popularLink;
/*
 * Tänkt att man lägger gui här när pogramet fungerar som det ska och lägger till möjlihter att manipular källa
 * 
 * 
 * 
 */


	private Main() {
		popularLink = new PopularLink();
		popularLink.getAllArticels();
		//popularLink.test();
	}

	public static void main(String[] args) {
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		new Main();

		System.out.println(new Timestamp(date.getTime()));
	}

}
