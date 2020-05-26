public class Task9{
	public static void main(String[] args){
		System.out.println("Enter five values with a space.");
		Double n1 = Double.parseDouble(args[0]);
		Double n2 = Double.parseDouble(args[1]);
		Double n3 = Double.parseDouble(args[2]);
		Double n4 = Double.parseDouble(args[3]);
		Double n5 = Double.parseDouble(args[4]);
		if (args.length == 5) {
			Double eps = 1E-5;

			if (Math.abs(((n1-n4)*(n1-n4) + (n2-n5)*(n2-n5)) - n3*n3) <= eps ){
				System.out.println("Point is in cicrle.");

			} else {
				System.out.println("Point isn't in cicrle.");
			}
		} else {
			System.out.println("Enter five values, please.");
		}
	}
}