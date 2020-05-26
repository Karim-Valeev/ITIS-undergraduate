public class Task3{
	public static void main(String[] args){
		int n=0;
		n = Integer.parseInt(args[0]);
		if (n>0) {
			double pi = 1;
			for (double i = 1; i <= n; i++) {
				pi = pi * ((4*i*i)/( (2*i-1) * (2*i+1) ));
			}
			System.out.println(2*pi);


		} else {
			System.out.println("STOP RIGHT THERE CRIMINAL SCUM!");
		}
	}
}