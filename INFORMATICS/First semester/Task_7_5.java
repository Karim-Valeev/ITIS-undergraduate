import java.util.Scanner;

public class Task_7_5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a positive integer and not equal to three.");
		if ((sc.hasNextInt()) && (sc.nextInt() != 3 ) ) {
			
			int x  = sc.nextInt();
			Double s=0.0;
			
			for (int i = 0; i <= x - 1; i++) {
				s += 1/(Math.pow(x,2*i+1)-3);
			
			}
			System.out.println(s);

		} else {
			System.out.println("Please, enter a positive integer and not equal to three.");
		}
	}
}
