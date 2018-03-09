import java.util.Scanner;

public class Stensaxpase {
	
	public static void main(String[] args) {
		Stensaxpase ssp = new Stensaxpase();
		Animation a = new Animation();
		
		System.out.println(a.getSten());
		try { Thread.sleep(800); }
		catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(a.getSax());
		try { Thread.sleep(800); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(a.getPase());
		try { Thread.sleep(800); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println("STEN SAX PÅSE");
		System.out.println("Det är bäst av tre!");
		System.out.println("Mata in 1 för sten, 2 för sax och 3 för påse för att starta spelet!");
		
		ssp.spel();
	}
	
	public void spel() {
		int pointsspelare = 0;
		int pointscpu = 0;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			Stensaxpase p = new Stensaxpase(); // Skapar objekt av denna klassen, så att vi kan använda oss av de metoder vi skapat
		
			int spelare = scan.nextInt();
			
			// Om spelaren har matat in rätt (1 för sten, 2 för sax eller 3 för påse)
			if ( spelare == 1 || spelare == 2 || spelare == 3) {
				Resultat r = new Resultat(spelare);
				System.out.println("Du valde " + p.getSpelarVal(spelare) + " och datorn valde " + p.getDatorVal(r.getDator()));
				
				if 		( r.getVinst() == 1 ) 	{ pointsspelare += 1; }
				else if ( r.getVinst() == 2 )	{ pointscpu += 1; }
				
				System.out.println("Du har " + pointsspelare + " poäng och datorn har " + pointscpu + " poäng" );
			}
			// Om spelaren har matat in fel (inte 1, 2 eller 3)
			else { System.out.println("Fel inmatning!"); }
			
			// Om spelaren eller datorn har fått 2 poäng, alltså vunnit
			if (pointsspelare == 2 || pointscpu == 2) { 
				if (pointsspelare == 2) 	{ System.out.println("Du vann!"); }
				else if ( pointscpu == 2) 	{ System.out.println("Du förlorade!"); }
				
				pointsspelare = 0;
				pointscpu = 0;
				
				System.out.println("Vill du spela igen? Mata in ja eller nej");
				String spela = scan.next();
				if (spela.equals("nej")) {
					System.exit(0);
				}
				else if (spela.equals("ja")) {
					System.out.println("Mata in 1 för sten, 2 för sax och 3 för påse för att starta spelet!");
				}
				else {
					System.out.println("Fel inmatning!"); 
				}
			}
			//Om ingen har fått 2 poäng än
			else {
				System.out.println("--------------------------------------------");
				System.out.println("Mata in 1 för sten, 2 för sax och 3 för påse");
			}
			
		}
	}
	
	// Metoder som omvandlar valet från siffra till text för spelare och dator
	public String getSpelarVal(int spelare) {
		if ( spelare == 1 ) { return "Sten"; }
		if ( spelare == 2 ) { return "Sax"; }
		else { return "Påse"; }
	}
	public String getDatorVal(int dator) {
		if ( dator == 1 ) { return "Sten"; }
		if ( dator == 2 ) { return "Sax"; }
		else { return "Påse"; }
	}
}