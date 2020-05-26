public class Task7{
	public static void main(String[] args){
		
		
		int n = Integer.parseInt(args[0]);
		double s=1;
		if (n>0) {
			for(double i=2; i<=n; i++){
				if ((i % 2) == 0){
					s = s - 1 / ((2*i-1)*(2*i-1));
				} else {
					s = s + 1/((2*i-1)*(2*i-1));
				}
			}
			System.out.println(s);
			System.out.println();
			func(n);


		} else {
			System.out.println("STOP RIGHT THERE CRIMINAL SCUM!");
		}
	}

	public static void func(int n) {
		double s=1;
		if (n>0) {
			for(double i=2; i<=n; i++){
				if ((i % 2) == 0){
					s = s - 1 / ((2*i-1)*(2*i-1));
				} else {
					s = s + 1/((2*i-1)*(2*i-1));
				}

			}
			System.out.println(s);
			
		} 
	}
}
