import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String str  = scnr.next();
		
		int n = str.length();
		int k = 0;

		if (n % 2 == 0) {
			for (int i = 0; i < n/2; i++) {
				if (str.charAt(i) != str.charAt(n-1-i)) {
					k++;
					System.out.println("Not palindrome.");
					break;
				} 
			}
			if (k==0) {
				System.out.println("Palindrome");
			}
		} else {
			for (int i = 0; i < n/2; i++) {
				if (str.charAt(i) != str.charAt(n-1-i)) {
					k++;
					System.out.println("Not palindrome.");
					break;
				} 
			}
			if (k==0) {
				System.out.println("Palindrome");
			}
		}

	}
}