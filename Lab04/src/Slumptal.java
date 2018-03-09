import java.util.Random;

public class Slumptal {
	private int randomnum; // attribut
	
	public Slumptal(int min, int max) {
		Random r1 = new Random();
		this.randomnum = r1.nextInt(max) + min;
	}
	public int getRandomNum() {
		return randomnum;
	}
}