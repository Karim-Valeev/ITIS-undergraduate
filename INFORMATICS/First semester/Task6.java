public class Task6{

	public static void main(String[] args){
		double s = 0.5;
	
		int factorial1 = 1;
		int factorial2 = 2;

		int n;
		n = Integer.parseInt(args[0]);
		
		if (n>0) {
			for(int m=2; m<=n; m++){
				
				factorial1 = factorial1 * (m-1);
				factorial2 = factorial2 * (2*m-1)*(2*m);
				
				s +=  (double) factorial1 * factorial1 / factorial2;
			}
			System.out.println(s);

		} else {
			System.out.println("STOP RIGHT THERE CRIMINAL SCUM!");
		}
	}
}