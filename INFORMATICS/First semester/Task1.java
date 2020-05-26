public class Task1{
	public static void main(String[] args){
		double b = 0;
		b = Double.parseDouble(args[0]);
		if (args.length() == 1) {
			if (b>0) {
				double a = 9.81*b*b*0.5;
				System.out.println(a +"m");
			} else {
				System.out.println("Input something bigger than zero.");
			}
		} else {
			System.out.println("Input one value!");
		}	
	}
}