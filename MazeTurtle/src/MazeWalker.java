import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;

public class MazeWalker {
	private Turtle turtle;
	
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}
	
	/** Låter sköldpaddan vandra genom labyrinten maze, från
	ingången till utgången. */
	public void walk(Maze maze) {
		int u = 0;
		int alpha = 0;
		turtle.turnNorth();
		turtle.penDown();
		while ( maze.atExit(turtle.getX(), turtle.getY()) == false ) {
			turtle.forward(1);
			u++;
			SimpleWindow.delay(0);
			if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(),turtle.getY()) != true) {
				turtle.left(90);
				alpha++;
			}
			if (maze.wallInFront(turtle.getDirection(), turtle.getX(),turtle.getY()) == true) {
				turtle.left(-90);
				alpha++;
				if (maze.wallInFront(turtle.getDirection(), turtle.getX(),turtle.getY()) == true) {
					turtle.left(-90);
					alpha++;
				}
			}
		}
		System.out.println("Antal steg: " + u); 
		System.out.println("Antal vinkeländringar: " + alpha);
	}
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "wow");
		
		System.out.println("Vilken bana vill du köra? (1-5)");
		Scanner scan = new Scanner(System.in);
		int nmr = scan.nextInt();
		Maze m = new Maze(nmr);
		m.draw(w);
	
		Turtle t = new Turtle(w,m.getXEntry(), m.getYEntry());
		MazeWalker mw = new MazeWalker(t);
		
		mw.walk(m);
	}
}
