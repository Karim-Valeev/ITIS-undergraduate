import java.util.Scanner;

public class CompareToIgnoreCase{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String str1  = scnr.next();
		String str2  = scnr.next();
		System.out.println();

		System.out.println(str1.compareToIgnoreCase(str2));
		// I have to change the order of functions to use initial strings in original method.
		// with for compare A and a
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		int k = 0;
		int n1 = str1.length();
		int n2 = str2.length();

		int m = n1 >= n2 ? n2 : n1;

		for (int i = 0; i<m; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				k++;
				System.out.println(str1.charAt(i) - str2.charAt(i));
				break;
			}
		}
		
		if (k==0) {
			System.out.println(Math.abs(n1-n2));
		}
	}
}