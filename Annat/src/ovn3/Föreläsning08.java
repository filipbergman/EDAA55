package ovn3;

import java.util.Random;
import java.util.Scanner;

public class Föreläsning08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r1 = new Random();
		int random = r1.nextInt(3);
		random += 1;
		System.out.println(random);
		while (true) {
			int nbr1 = scan.nextInt();
			switch(nbr1) {
				case 1:
					System.out.println("du skrev 1");
					break;
				case 2:
					System.out.println("du skrev 2");
					break;
				case 3:
					System.out.println("du skrev 3");
					break;
				case 4:
					System.out.println("du skrev 4");
					break;
				default:
					System.out.println("Du skrev unte 1,2,3 eller 4");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
