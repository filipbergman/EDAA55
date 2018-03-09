import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		BankApplication app = new BankApplication();
		app.runApplication();
	}

	private void runApplication() {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		long accNr;
		long idNr;

		while (true) {
			meny();
			int val = scan.nextInt();
			scan.nextLine();

			switch (val) {
			// Hitta konto utifrån innehavare
			case 1:
				System.out.println("Id: ");
				idNr = scan.nextLong();
				if (bank.findHolder(idNr) != null) {
					for (int i = 0; i < bank.findAccountsForHolder(idNr).size(); i++) {
						System.out.println(bank.findAccountsForHolder(idNr).get(i));
					}
				} else
					System.out.println("Det finns inga konton med detta id!");
				break;
			// Sök kontoinnehavare utifrån (del av) namn
			case 2:
				System.out.println("namn: ");
				String partOfName = scan.nextLine();
				if (bank.findByPartofName(partOfName).size() != 0) {
					for (int i = 0; i < bank.findByPartofName(partOfName).size(); i++) {
						System.out.println(bank.findByPartofName(partOfName).get(i));
					}
				} else
					System.out.println("inget sådant konto finns!");
				break;
			// Sätt in
			case 3:
				System.out.println("konto: ");
				accNr = scan.nextLong();
				if (bank.findByNumber(accNr) != null) {
					System.out.println("belopp: ");
					double insättning = scan.nextDouble();
					if (!(insättning < 0)) {
						bank.findByNumber(accNr).deposit(insättning);
						System.out.println(bank.findByNumber(accNr));
					} else
						System.out.println("negativa belopp är ej tillåtna!");
				} else
					System.out.println("felaktigt kontonummer!");
				break;
			// Ta ut
			case 4:
				System.out.println("från konto: ");
				accNr = scan.nextInt();
				if (bank.findByNumber(accNr) != null) {
					System.out.println("belopp: ");
					double withdraw = scan.nextDouble();
					if (!(withdraw < 0)) {
						if (withdraw <= bank.findByNumber(accNr).getAmount()) {
							bank.findByNumber(accNr).withdraw(withdraw);
							System.out.println(bank.findByNumber(accNr));
						} else
							System.out.println("uttaget misslyckades, endast " + bank.findByNumber(accNr).getAmount()
									+ " på kontot!");
					} else
						System.out.println("negativa belopp är ej tillåtna!");
				} else
					System.out.println("felaktigt kontonummer!");
				break;
			// Överföring
			case 5:
				System.out.println("från konto: ");
				accNr = scan.nextLong();

				if (bank.findByNumber(accNr) != null) {
					System.out.println("till konto: ");
					double accNr2 = scan.nextInt();

					if (bank.findByNumber(accNr2) != null) {
						System.out.println("belopp: ");
						double amount = scan.nextDouble();
						if (!(amount < 0)) {
							if (amount <= bank.findByNumber(accNr).getAmount()) {
								bank.findByNumber(accNr).withdraw(amount);
								bank.findByNumber(accNr2).deposit(amount);
								System.out.println(bank.findByNumber(accNr));
								System.out.println(bank.findByNumber(accNr2));
							} else
								System.out.println("uttaget misslyckades, endast " + bank.findByNumber(accNr).getAmount()
										+ " på kontot!");
						} else
							System.out.println("negativa belopp är ej tillåtna!");
					} else
						System.out.println("felaktigt kontonummer!");
				} else
					System.out.println("felaktigt kontonummer!");
				break;
			// Skapa konto
			case 6:
				System.out.println("namn: ");
				String name = scan.nextLine();
				System.out.println("id: ");
				idNr = scan.nextLong();
				System.out.println("Konto skapat: " + bank.addAccount(name, idNr));
				break;
			// Ta bort konto
			case 7:
				System.out.println("konto: ");
				accNr = scan.nextLong();
				if (bank.findByNumber(accNr) != null) {
					bank.removeAccount(accNr);
				} else
					System.out.println("felaktigt kontonummer!");
				break;
			// Skriv ut konton
			case 8:
				if (bank.getAllAccounts().size() == 0) {
					System.out.println("Det finns inga kunder!");
				} else
					for (int i = 0; i < bank.getAllAccounts().size(); i++) {
						System.out.println(bank.getAllAccounts().get(i));
					}
				break;
			// Avsluta
			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("Fel inmatning!");
				break;
			}
		}
	}

	private void meny() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");
		System.out.println("Val: ");
	}
}
