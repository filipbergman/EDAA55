import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String [] args) {
		
		ArrayList <RaceTurtle> list = new ArrayList <RaceTurtle>();
		RaceWindow w = new RaceWindow();
		Random rand = new Random();
		
		// Skapar 8 Raceturtle objekt i RaceWindow och lägger till objekten i listan "list".
		for (int i = 1 ; i < 9 ; i++) {
			int r = rand.nextInt(3);
			if ( r == 0 ) { 
				RaceTurtle x = new MoleTurtle(w, i);
				list.add(x);
			}
			else if ( r == 1 ) {
				int m = rand.nextInt(101);
				RaceTurtle x = new AbsentMindedTurtle(w, i, m);
				list.add(x);
			}
			else {
				RaceTurtle x = new DizzyTurtle(w, i);
				list.add(x);
			}
		}
		for ( int s = 0 ; s < list.size(); s++) {
			System.out.println(list.get(s).toString());
		}
		// Skapar en lista "finished" där RaceTurtles som gått i mål ska läggas in.
		ArrayList <RaceTurtle> finished = new ArrayList <RaceTurtle>();
		
		// Loopar genom alla turtles som finns kvar i listan list tills den blir tom 
		while( !list.isEmpty() ) {
			for( int i = 0; i < list.size(); i++) {
				
				// list.get(i) returnerar ett objekt av de tre olika typerna, racestep i denne klassen anropas då
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
			System.out.println("På plats " + (i + 1) + ": " + finished.get(i));
			// Kan ta bort toString() då det föräntas en String
		}
		
		
	}
}
