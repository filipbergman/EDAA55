import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleDel5 {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDel5");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		for (int i = 1; i <= 1000; i++) {
			t.forward(rand.nextInt(30) + 1);
			t.left(rand.nextInt(360) -180);
		}
	}
}