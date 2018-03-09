import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		int oldx = 250;
		int oldy = 250;
		Square sq = new Square(oldx, oldy, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			sq.erase(w);
			int difx = w.getMouseX() - oldx;
			int dify = w.getMouseY() - oldy;
			
			int modulox = (difx%10);			// Kollar om kvadraten har ett avstånd i x-resp.y-led från musklickets position efter tio steg
			int moduloy = (dify%10);
			
			for (int i = 0; i < 10; i++) {
				if ( i < 9 ) {
					sq.move(difx / 10, dify / 10);
					sq.draw(w);
					SimpleWindow.delay(10);
					sq.erase(w);
				}
				
				// För att flytta kvadraten exakt till den positionen man klickade på
				else {
					sq.move(difx / 10 + modulox, dify / 10 + moduloy);
					sq.draw(w);
				}
			}
			oldx = sq.getX();
			oldy = sq.getY();
		}
	}
}