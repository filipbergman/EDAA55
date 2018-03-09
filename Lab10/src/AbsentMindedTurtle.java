public class AbsentMindedTurtle extends RaceTurtle {
	private int tankspriddhet;
		
	public AbsentMindedTurtle(RaceWindow w, int nbr, int tankspriddhet) {
		super(w, nbr);
		this.tankspriddhet = tankspriddhet;
	}
	
	public void raceStep() {
		int rand = slump.nextInt(101);
		if ( rand > tankspriddhet ) {
			super.raceStep();
		}
	}
	
	/**
	* Returnerar en läsbar representation av denna RaceTurtle.
	*/
	public String toString() {
		return (super.toString() + " - " + "AbsentMindedTurtle (" + tankspriddhet + "% Fråndvarande)");
	}
	
}
