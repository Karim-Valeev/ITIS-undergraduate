import java.util.Scanner;

public class Task_7_6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a positive integer and not equal to three.");
		if (sc.hasNextInt()) {

			int x  = sc.nextInt();
			if (x!=3 && x>0) {
				Double s = 0.0;
			
				for (int i = 0; i <= x - 1; i++) {
					s += 1/(Math.pow(x,2*i+1)-3);
			
				}
				System.out.println("\n" + s);

			} else {
				System.out.println("Please, enter a positive integer and not equal to three.");
			}

		} else {
			System.out.println("Please, enter a positive integer and not equal to three.");
		}
	}
}
