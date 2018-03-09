package ovn3;

public class Frog {
	private int x;
	private int y;
	private int meters;
	
	public Frog() {
		x = 0;
		y = 0;
		meters = 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void jumpNorth(int n) {
		y += n;
		meters += 1;
	}
	public void jumpSouth(int n) {
		y -= n;
		meters += 1;
	}
	
	public void jumpWest(int n) {
		x -= n;
		meters += 1;
	}
	
	public void jumpEast(int n) {
		x += n;
		meters += 1;
	}
	
	public int getMeters() {
		return meters;
	}
}
