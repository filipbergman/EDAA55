import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleDel6 {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDel6");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		int difx = (t1.getX() - t2.getX());
		int dify = (t1.getY() - t2.getY());
		
		while (Math.sqrt(Math.pow(difx, 2) + Math.pow(dify, 2)) >= 50) {
			t1.forward(rand.nextInt(30) + 1);
			t1.left(rand.nextInt(360) - 180);
		
			t2.forward(rand.nextInt(30) + 1);
			t2.left(rand.nextInt(360) - 180);
			difx = (t1.getX() - t2.getX());
			dify = (t1.getY() - t2.getY());
			SimpleWindow.delay(3);
		}
		System.out.println("Skillnaden mellan t1 och t2 blev i slutet: " + Math.sqrt(Math.pow(difx, 2) + Math.pow(dify, 2)));
	}
}