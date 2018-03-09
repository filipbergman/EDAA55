public class Mole {
	
	private Graphics g = new Graphics(30, 50, 10); 	// skapar nytt objekt av klassen Graphics
	
	public static void main(String[] args) {
		Mole m = new Mole();						// Skapar nytt objekt av klassen Mole, här finns de metoder vi använder
		m.drawWorld();
		m.drawSky();
		m.drawGrass();
		m.dig();
	}
	
	public void drawWorld(){
		g.rectangle(0, 20, 30, 30, Colors.SOIL);
	}
	public void drawSky() {
		g.rectangle(0, 0, 30, 20, Colors.SKY);
	}
	public void drawGrass() {
		g.rectangle(0, 19, 30, 1, Colors.GRASS);
	}
	public void dig() {
		int x = g.getWidth() / 2; 	// För att börja på mitten
		int y = g.getHeight() / 2;
		while (true) {
			g.block(x, y, Colors.MOLE); // Mullvaden målas ut först i mitten, sedan efter varje tangentklick
			char key = g.waitForKey();
			
			if 		( y > 19 ) 	{ g.block(x, y, Colors.TUNNEL); }	// Om mullvaden är under gräset
			else if ( y == 19 ) { g.block(x, y, Colors.GRASS); }	// Om mullvaden är på gräset
			//else if ( y < 19 )  { g.block(x, y, Colors.SKY); }    // Ifall man vill att mullvaden ska vara ovan på gräset
			
			// Hur den ska röra sig när man klickar på en tangent
			if 		(key == 'w' && y > 19) 	{ y--; }
			else if (key == 'a' && x > 0)  	{ x--; }
			else if (key == 's' && y < 49) 	{ y++; }
			else if (key == 'd' && x < 29) 	{ x++; }
		}
	}
}