import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w; 	// Skapar ett fönster
	private boolean isPenDown;	// Skapar en variabel som antingen är true eller false beroende på om pennan är nere.
	private double x;
	private double y;
	protected double direction;
	
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		direction = Math.PI / 2;
		isPenDown = false;
	}

	/** Sänker pennan. */
	public void penDown() {
		this.isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		this.isPenDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int) Math.round(x), (int) Math.round(y));
		x += n * Math.cos(direction);
		y -= n * Math.sin(direction);
		
		if (isPenDown) {
			w.lineTo((int) Math.round(x),(int) Math.round(y));
		}
		else {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction += (beta * Math.PI / 180);
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = (90 * Math.PI / 180);
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
	
	public boolean isPenDown() {
		return isPenDown;
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return ((int) Math.round(direction / (2*Math.PI) * 360));
	}
}
