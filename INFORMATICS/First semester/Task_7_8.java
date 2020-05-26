import java.util.Scanner;

public class Task_7_8 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter positive integer.");
		if (sc.hasNextInt()) {

			int n  = sc.nextInt();

			System.out.print("\n" + 1 + " ");
			
			if (n > 0) {
				
				if (n%2==0) {

					for (int i = 2; i<=n/2; i++) {
						
						if (n % i == 0) {
							System.out.print(i + " ");
						}

					}

				} else {

					for (int i = 3; i <= n/3 ; i++) {

						if (n % i == 0) {
							System.out.print(i + " ");
						}
				
					}
				}
				
			} else {
				System.out.println("Please, enter positive integer.");
			}

			System.out.println(n);

		} else {
			System.out.println("Please, enter positive integer.");
		}
		
		}
	}