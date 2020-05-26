import java.util.Scanner;

public class Task_7_7 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two positive integers.");
		if (sc.hasNextInt() && sc.hasNextInt()) {

			int n1  = sc.nextInt();
			int n2  = sc.nextInt();
			
			if (n1 > 0 && n2 > 0) {
				System.out.println("\n" + "The smallest common multiple of given numbers is: " + n1*n2/nod(n1,n2));

			} else {
				System.out.println("Please, enter two positive integers.");
			}

		} else {
			System.out.println("Please, enter two positive integers.");
		}
	}

	public static int nod(int a,int b) {
        while (b !=0) {
            int remainderOfTheDivision = a%b;
            a = b;
            b = tremainderOfTheDivision;
        }
        return a;
    }
}
