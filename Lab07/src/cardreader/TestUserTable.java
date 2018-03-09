package cardreader;

public class TestUserTable {
	public static void main(String [] args) {
		UserTable u = new UserTable();
		
		User v = new User((1234), "Filip Bergman");
		u.add(v);
		System.out.println(u.find(24073));
		System.out.println(u.find(1234));
		System.out.println(u.findByName("Jens Holmgren"));
//		u.print();
	}
}
