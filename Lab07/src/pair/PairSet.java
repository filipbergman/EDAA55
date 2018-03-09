package pair;
import java.util.Random;

public class PairSet {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();
	
	/** Skapar en mängd av alla talpar (a,b) sådana att
        0 <= a < rows  och  0 <= b < cols */
	public PairSet(int rows, int cols) {
		n = rows * cols;
		pairs = new Pair[n];
		int pos = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				pairs[pos] = new Pair(i,k);
				pos++;
			}
		}
		
		// skapa paren, lägg in dem i vektorn
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		if (pairs[0] != null) {
			return true;
		}
		return false;
	}

	/** Hämtar ett slumpmässigt valt talpar ur mängden. Mängden
	 	blir ett element mindre. Om mängden är tom returneras null. */
	public Pair pick() {
		if (more() == true) {
			Pair p;
			int x = rand.nextInt(n);
			p = pairs[x];
			pairs[x] = pairs[n-1];
			pairs[n-1] = null;
			n--;
			return p;
		}
		else {
			return null;
		}
		
	}
}
