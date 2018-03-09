package ovn3;

public class Person {
	private String namn;
	private String efternamn;
	
	public Person(String namn, String efternamn) {
		this.namn = namn;
		this.efternamn = efternamn;
	}
	
	public String getNamn() {
		return namn;
	}
	
	public String getEfternamn() {
		return efternamn;
	}
}
