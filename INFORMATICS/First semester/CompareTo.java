import java.util.Scanner;

public class CompareTo{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String str1  = scnr.next();
		String str2  = scnr.next();
		int k = 0;

		int n1 = str1.length();
		int n2 = str2.length();
		System.out.println();

		int m = n1 >= n2 ? n2 : n1;

		for (int i = 0; i<m; i++) {
			if (str1.charAt(i) == str2.charAt(i)) {

			} else if (str1.charAt(i) != str2.charAt(i)) {
				k++;
				System.out.println(str1.charAt(i) - str2.charAt(i));
				break;
			}
		}
		
		if (k==0) {
			System.out.println(Math.abs(n1-n2));
		}





		System.out.println(str1.compareTo(str2));

	}
}