import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str  = sc.next();
		String reversestr = "";
		
		int n = str.length();
		
		for (int i = n-1; i >=0; i--) {
			reversestr += str.charAt(i);
		}

		System.out.println("\n" + reversestr);
	}
}
