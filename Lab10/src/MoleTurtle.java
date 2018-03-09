public class MoleTurtle extends RaceTurtle {
	
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	public void raceStep() {
		boolean gräva = slump.nextBoolean();
		if ( gräva ) {
			penUp();
		}
		else 
			penDown();
		
		super.raceStep();
	}
	
	/**
	* Returnerar en läsbar representation av denna RaceTurtle.
	*/
	public String toString() {
		return (super.toString() + " - Moleturtle");
	}
}
