public class Resultat {
	private int spelare;
	private int cpu;
	Slumptal s = new Slumptal(1, 3);
	
	public Resultat(int spelare) {
		this.spelare = spelare;
		this.cpu = s.getRandomNum();
	}
	public int getVinst() {
		if (spelare == s.getRandomNum()) 	{ return 0; } // Lika
		else if (spelare == 1 && cpu == 2) 	{ return 1; } // Vinst
		else if (spelare == 2 && cpu == 3) 	{ return 1; } // Vinst
		else if (spelare == 3 && cpu == 1) 	{ return 1; } // Vinst
		else								{ return 2; } // Förlust
	}
	public int getDator() {
		return cpu; 
	}
}