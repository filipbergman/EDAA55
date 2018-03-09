import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	protected Random slump = new Random();
	
	/**
	* Skapar en sköldpadda som ska springa i fönstret w och som har start-
	* nummer nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	*/
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		penDown();
		this.nbr = nbr;
		direction = 0;
		// Kan använda direction tack vare att jag ändrade "private direction" till "protected direction" i klassen Turtle.  
	}
	/**
	* Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	* slumptal (heltal) mellan 1 och 6.
	*/
	public void raceStep() {
		forward(slump.nextInt(6) + 1);
	}
	/**
	* Returnerar en läsbar representation av denna RaceTurtle,
	* på formen "Nummer x" där x är sköldpaddans startnummer.
	*/
	public String toString() {
		return ("Nummer " + nbr);
	}
}
