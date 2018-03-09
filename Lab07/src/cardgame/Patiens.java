package cardgame;
import pair.Pair;
import pair.PairSet;

public class Patiens {
	private static final int NBR_ITERATIONS = 1000000;
	
	public static void main(String[] args) {
		int won = 0;
		for ( int i = 0; i < NBR_ITERATIONS; i++) {
			PairSet cardDeck = new PairSet(4, 13);
			
			int count = 0;
			while (cardDeck.more()) {
				Pair p = cardDeck.pick();
				if ( p.second() == count ) break;
				count++;
				if (count == 3) count = 0;
				if (!cardDeck.more()) won++;
			}
		}
		System.out.println("Andel vunna patienser: " + ((double)won / (double)NBR_ITERATIONS));
	}
}