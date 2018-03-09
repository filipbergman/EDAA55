import java.util.ArrayList;

public class TurtleRace {

	public static void main(String [] args) {
		
		ArrayList <RaceTurtle> list = new ArrayList <RaceTurtle>();
		RaceWindow w = new RaceWindow();
		
		// Skapar 8 Raceturtle objekt i RaceWindow och lägger till objekten i listan "list".
		for (int i = 1 ; i < 9 ; i++) {
			RaceTurtle x = new RaceTurtle(w, i);
			list.add(x);
		}
		
		// Skapar en lista "finished" där RaceTurtles som gått i mål ska läggas in.
		ArrayList <RaceTurtle> finished = new ArrayList <RaceTurtle>();
		
		// Loopar genom alla turtles som finns kvar i listan list tills den blir tom 
		while( !list.isEmpty() ) {
			for( int i = 0; i < list.size(); i++) {
				
				list.get(i).raceStep();
				RaceWindow.delay(1);
				
				// De som gått i mål tas bort från listan "list" samtidigt som de läggs till sist i "finished".
				if (list.get(i).getX() >= RaceWindow.X_END_POS) {
					finished.add(list.remove(i));
					i--;
				}
			}
		}
		
		// Skriver ut ordningen som RaceTurtles kom i mål
		for( int i = 0 ; i < 3 ; i++) {
			System.out.println("På plats " + (i + 1) + ": " + finished.get(i).toString());
			// Kan ta bort toString() då det föräntas en String
		}
		
		
	}
}
