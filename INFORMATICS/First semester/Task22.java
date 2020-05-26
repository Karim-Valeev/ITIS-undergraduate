import java.util.Scanner;

public class Task22 {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String str  = scnr.next();
		System.out.println();
		String x = "";

		int n = str.length();
		int k = 0;
		int l = 0;
		// If integer can start with the ZERO, then I can cut down several lines

		for (int i = 1; i<n; i++) {
			x = ""+str.charAt(i);
			if (".,".contains(x)) {
				k++;
			}
		}

		for (int i = 1; i<n; i++) {
			x = ""+str.charAt(i);
			if (! "-+.,1234567890".contains(x)) {
				l++;
			} 
		}

		if (k==0) {
			
			for (int i = 1; i < n; i++) {
				
				x = "" + str.charAt(0);
				if (! "+-123456789".contains(x)){
					System.out.println("Your input is String.");
					break;
				}

				x="" + str.charAt(i);
				if (! "0123456789".contains(x)) {
					System.out.println("Your input is String.");
					break;
				}
			}

			if (k==0 && l==0 && str.charAt(0) != '0'){
				System.out.println("Your input is Integer.");
			}

		} else if (k==1) {
			for (int i = 1; i < n; i++) {
				
				x = "" + str.charAt(0);
				if (! "+-0123456789".contains(x)) {
					System.out.println("Your input is String.");
					break;
				}

				x = "" + str.charAt(i);
				if (! "0123456789.,".contains(x)) {
					System.out.println("Your input is String.");
					break;
				}
			}

			if (k==1) {
				System.out.println("Your input is Double.");
			}
		} else {
			System.out.println("Your input is String.");
		}

	}
}