public class BankAccount {
	private Customer holder;
	private int accountNumber;
	private double amount;
	private static int x = 1001;
	
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	* id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	public BankAccount(String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		amount = 0;
		accountNumber = x;
		x++;
	}
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	public BankAccount(Customer holder) {
		this.holder = holder;
		amount = 0;
		accountNumber = x;
		x++;
	}
	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}
	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
		return accountNumber;
	}
	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return amount;
	}
	/** Sätter in beloppet ’amount’ på kontot. */
	public void deposit(double amount) {
		this.amount += amount;
	}
	/**
	* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	public void withdraw(double amount) {
		this.amount -= amount; 
	}
	
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "Konto " + accountNumber + " (" + holder.toString() + "): " + amount;
	}
}
