import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> list = new ArrayList<BankAccount>();

	/** Skapar en ny bank utan konton. */
	public Bank() {
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		for (int i = 0; i < list.size(); i++) {
			if (findHolder(idNr) == list.get(i).getHolder()) {
				BankAccount konto = new BankAccount(findHolder(idNr));
				list.add(konto);
				return konto.getAccountNumber();
			}
		}
		BankAccount konto = new BankAccount(holderName, idNr);
		list.add(konto);
		return konto.getAccountNumber();
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getHolder().getIdNr() == idNr) {
				return list.get(i).getHolder();
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(long accNr) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNumber() == accNr) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		if (list.size() == 0) {
			return list;
		}
		else {
			ArrayList<BankAccount> sortedList = new ArrayList<BankAccount>();
			ArrayList<BankAccount> copyList = new ArrayList<BankAccount>();

			for (int i = 0; i < list.size(); i++) {
				copyList.add(list.get(i));
			}

			while (copyList.size() > 1) {
				int minIndex = 0;
				String min = copyList.get(0).getHolder().getName();
				for (int k = 0; k < copyList.size(); k++) {
					if (min.compareToIgnoreCase(copyList.get(k).getHolder().getName()) > 0) {
						minIndex = k;
						min = copyList.get(k).getHolder().getName();
					}
				}
				sortedList.add(copyList.remove(minIndex));
			}
			sortedList.add(copyList.get(0));
			return sortedList;
		}
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	public BankAccount findByNumber(double accNr) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNumber() == accNr) {
				return list.get(i);
			}
		}
		return null;
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(double idNr) {
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getHolder().getIdNr() == idNr) {
				accountList.add(list.get(i));
			}
		}
		return accountList;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	public ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> nameList = new ArrayList<Customer>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				nameList.add(list.get(i).getHolder());
			}
		}
		return nameList;
	}
}
