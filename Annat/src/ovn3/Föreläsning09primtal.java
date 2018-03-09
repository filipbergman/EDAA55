package ovn3;

public class Föreläsning09primtal {
	public static void main(String[] args) {
		int length = 100;
		double [] v = new double[length];
		int rest = 0;
		System.out.println("1 är ett primtal\n2 är ett primtal");
		
		for ( int i = 1; i < v.length; i++) {
			v[i] = i;
			
			for ( int n = 1; n <= i; n++) {
				if ( v[i]%n != 0 ) { rest++; }
				if ( i > 2 && rest == (i-2)) {
					System.out.println(i + " är ett primtal");
					break;
				}
			}
			rest = 0;
		}
	}
}
