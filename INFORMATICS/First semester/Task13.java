public class Task13{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		a = a + b;
		b = b - a;
		b = -b;
		a = a - b;
		System.out.println("New a = " + a + " and new b = " + b);
	}
}