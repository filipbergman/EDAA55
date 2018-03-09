import java.util.ArrayList;

public class User {
	private String name;
	private int id;
	private ArrayList<User> friends;
	private ArrayList<Activity> activities;
		
	/**
	 * Skapar en ny användare med namnet name, id-numret id och utan vänner eller
	 * aktiviteter
	 */
	public User(String name, int id) {
		this.name = name;
		this.id = id;
		friends = new ArrayList<User>();
		activities = new ArrayList<Activity>();
	}
	/**
	 * Lägger till användare u som vän till denna användare. Man får lov att anta
	 * att u inte redan är en vän
	 */
	public void addFriend(User u) {
		if (friends.size() == 0) {
			friends.add(u);
		}
		else {
			for(int i = 0 ; i < friends.size(); i++) {
				if(friends.get(i).id < u.id) {
					friends.add(i,u);
					break; // GLÖMM INTE DETTA
				}
			}
			friends.add(u);
		}
	}
	/**
	 * Letar upp den vän som har användar-id id. Returnerar null om ingen vän med
	 * detta id finns
	 */
	public User findFriend(int id) {
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).id == id) {
				return friends.get(i);
			}
		}
		return null;
	}
	/** Lägger till en ny aktivitet till denna användare */
	public void addActivity(Activity a) {
		activities.add(a);
	}

	/**
	 * Returnerar denna användares senast tillagda aktivitet. Returnerar null om
	 * inga aktiviteter finns
	 */
	public Activity getLatestActivity() {
		if (activities.size() == 0) {
			return null;
		} else {
			int k = 0;
			while (k < activities.size()) {
				k++;
			}
			return activities.get(k);
		}
	}
	/**
	 * Returnerar en lista över denna användares vänners senaste aktiviteter. Om
	 * användaren inte har några vänner eller om dess vänner inte har några
	 * aktiviteter returneras en tom lista.
	 */
	public ArrayList<Activity> getFeed() {
		ArrayList<Activity> aktiviteter = new ArrayList<Activity>();
		for(int i = 0; i < friends.size(); i++) {
			aktiviteter.add(friends.get(i).getLatestActivity());
		}
		return aktiviteter;
	}

	/**
	 * Returnerar en lista över de användare som är vänner både till användaren u
	 * och denna användare. Om inga gemensamma vänner finns returneras en tom lista
	 */
	public ArrayList<User> findCommonFriends(User u) {
		ArrayList<User> comFriend = new ArrayList<User>();
		for(int i = 0; i < friends.size(); i++) {
			for(int k = 0; k < i; k++) {
				if( friends.get(i).id == u.friends.get(k).id ) {
					comFriend.add(friends.get(i));
				}
			}
		}
		return comFriend;
	}

	/** Returnerar användarens namn */
	public String toString() {
		return name;
	}
}
