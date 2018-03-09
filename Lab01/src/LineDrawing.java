import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 500);
		while (true) {
			w.waitForMouseClick();
			w.getMouseX();
			w.getMouseY();
			w.lineTo(w.getMouseX(), w.getMouseY());
			// vänta tills användaren klickar på en musknapp
			// rita en linje till den punkt där användaren klickade
		}
	}
}