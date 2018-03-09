import java.util.ArrayList;

public class Activity {
	private String text;
	private User owner;
	private ArrayList<User> likers;
	
	/** Skapar en ny aktivitet som tillhör användaren owner och
	består av texten text.
	Aktiviteten har från början noll gilla-markeringar */
	public Activity(String text, User owner) {
		this.text = text;
		this.owner = owner;
		likers = new ArrayList<User>();
		owner.addActivity(this); // sista punkten, man skriver i koden: Activity("hejsan", owner1); inte owner1.addActivity();
	}
	/** Lägger till en gilla-markering till denna aktivitet.
	Man får anta att användaren inte redan gillat inlägget */
	public void like(User u) {
		likers.add(u);
	}
	/** Returnerar antalet gilla-markeringar för denna aktivitet. */
	public int getNbrOfLikes() {
		return likers.size();
	}
	/** Returnerar den användare som skapade denna aktivitet. */
	public User getOwner() {
		return owner;
	}
	/** Returnerar en strängrepresentation av denna aktivitet.
	Aktiviteten ska representeras på formen:
	In this house, we obey the laws of thermodynamics!
	4 personer gillar detta:
	Montgomery Burns
	Marge Simpson
	Lionel Hutz
	Ned Flanders */
	public String toString() {
		String stringLikes = text + "\n" + likers.size() + " personer gillar detta:" + "\n";
		for (int i = 0 ; i < likers.size(); i++) {
			stringLikes += likers.get(i).toString()  + "\n";
		}
		return stringLikes;
	}
}
