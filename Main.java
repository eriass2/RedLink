import java.sql.Timestamp;
import java.util.Scanner;

import trie.StringRadixTreeMap;

public class Main {
	
	private PopularLink popularLink;
/*
 * T�nkt att man l�gger gui h�r n�r pogramet fungerar som det ska och l�gger till m�jlihter att manipular k�lla
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
