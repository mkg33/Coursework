import java.util.*;

public class XmasTree {
	
	 int level;
	
	public XmasTree(int level) {
		
		this.level = level;
		
	}
	
	
	public String toString() {
		
		String tree = "";
		
		XmasTree number = new XmasTree(level);
		
		for(int i=0; i<=number.level; i++) {
		
			tree += " ";
		
		
		}
		
		tree += "*";
		
		for(int i=0; i<=number.level; i++) {
			
			tree += " ";
			
		}
		
		tree += "\r";
		
		for(int i=1; i<=2*number.level; i++) {
			
			if(i%2!=0) {
				
			for(int j=number.level; j>=i/2 + 1; j--) {
				
				tree += " ";
				
			}
			
			tree += "/";
			
			for(int l=0; l<i; l++) {
				
				if(l%2==0) {
				
				tree += ".";
				
				}
				
				else {
					
					tree += ",";
					
				}
				
			}
			
			tree += "\\";
			
			tree += "\r";
			
			}
			
			else {
				
				for(int j=number.level; j>=i/2 + 1; j--) {
					
					tree += " ";
					
				}
				
				tree += "/";
				
				for(int l=0; l<=i; l++) {
					
					if(l%2==0) {
					
					tree += ",";
					
					}
					
					else {
						
						tree += ".";
						
					}
					
				}
				
				tree += "\\";
				
				tree += "\r";
				
			}
			
			
		}
		
	
		
		for(int i=0; i<number.level; i++) {
			
			tree += "^";
			
		}
		
		tree += "[_]";
		
		for(int i=0; i<number.level; i++) {
			
			tree += "^";
			
		}
		
		
		
		return tree;
	
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Bitte gib die Anzahl an Levels: ");
		
		Scanner scan = new Scanner(System.in);
		
		int antwort = scan.nextInt();
		
		XmasTree anzahl = new XmasTree(antwort);
		
		System.out.println(anzahl.toString());
		
		System.out.println("\n");
		
		/*Quelle: https://asciiart.website//index.php?art=holiday/christmas/santa */
		String santa = 
				"   FROHE WEIHNACHTEN!\r"+
				"           _\r"+
				"          {_}\r" + 
				"          / \\\r" + 
				"         /   \\\r" + 
				"        /_____\\\r" + 
				"      {`_______`}\r" + 
				"       // . . \\\\\r" + 
				"      (/(__7__)\\)\r" + 
				"      |'-' = `-'|\r" + 
				"      |         |\r" + 
				"      /\\       /\\\r" + 
				"     /  '.   .'  \\\r" + 
				"    /_/   `\"`   \\_\\\r" + 
				"   {__}###[_]###{__}\r" + 
				"   (_/\\_________/\\_)\r" + 
				"       |___|___|\r" + 
				"        |--|--|\r" + 
				"       (__)`(__)";
		
		System.out.println(santa); 
		
	}
	
	
}
