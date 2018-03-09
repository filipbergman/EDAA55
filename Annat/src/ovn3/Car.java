package ovn3;
import java.util.Scanner;

public class Car {
	private String nbr; 	// registreringnummer
	private Person owner; 	// ägare
	/** Skapar en bil med registreringsnummer licenseNbr som ägs av personen owner. */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Person p = new Person("Filip", "Bergman");
		System.out.println(p.getNamn());
		System.out.println(p.getEfternamn());
		
		String namn2 = scan.next();
		String efternamn2 = scan.next();
		Person p2 = new Person(namn2, efternamn2);
		System.out.println(p2.getNamn());
		System.out.println(p2.getEfternamn());
	}
	
	public Car(String licenseNbr, Person owner) {
		nbr = licenseNbr;
		this.owner = owner;
	}
	
	/** Tar reda på bilens registreringsnummer. */
	public String getLicenseNbr() {
		return nbr;
	}
	
	/** Tar reda på bilens ägare. */
	public Person getOwner() {
		return owner;
	}
	
	/** Sätter bilens ägare till newOwner. */
	public void changeOwner(Person newOwner) {
		owner = newOwner;
	}
}
