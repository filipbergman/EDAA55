public class DizzyTurtle extends RaceTurtle {
	int dizzyness;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		dizzyness = slump.nextInt(5) + 1;
	}

	public void raceStep() {
		
		int vingling = slump.nextInt(40) - 20; // Mellan 30 och -30 grader vingling
		if (dizzyness == 1) {
			left(vingling);
		} else if (dizzyness == 2) {
			left(vingling * 2);
		} else if (dizzyness == 3) {
			left(vingling * 3);
		} else if (dizzyness == 4) {
			left(vingling * 4);
		} else if (dizzyness == 5) {
			left(vingling * 5);
		}

		super.raceStep();

		// Återställer riktningen på DizzyTurtle:n om den gått för mycket uppåt eller
		if (getDirection() > 90 || getDirection() < -90)
			direction = 0;
	}

	/**
	 * Returnerar en läsbar representation av denna RaceTurtle.
	 */
	public String toString() {
		return (super.toString() + " - " + "DizzyTurtle (Yrsel: " + dizzyness + ")");
	}

}
