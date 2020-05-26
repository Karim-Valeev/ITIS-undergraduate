public class Task21 {
	public static void main(String[] args) {
		System.out.println("Please, enter 3 values a, b, and c for ax^2 + bx +c = 0.");
		System.out.println();
		Double a = Double.parseDouble(args[0]);
		Double b = Double.parseDouble(args[1]);
		Double c = Double.parseDouble(args[2]);
		if (args.length > 3) {
			System.out.println("Please, enter concretely 3 values.");
			return;
		}
		Double x1=0.0;
		Double x2=0.0;
		Double d = b*b - 4* a * c;
		if (d >= 0) {
			if (a!=0) {
				x1 = (-1*b + Math.sqrt(d)) / (2 * a);
				x2 = (-1*b - Math.sqrt(d)) / (2 * a);
				if (Math.abs(x1-x2) <= 1E-5) {
					System.out.println(x1);
				} else {
					System.out.println(x1);
					System.out.println(x2);
				}
			} else {
				if (b!=0) {
					System.out.println(-1*c/b);
				} else {
					System.out.println("There are no real roots.");
				}			
			}

		} else {
			System.out.println("There are no real roots.");

		}
	}
}