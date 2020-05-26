public class Task5{
	public static void main(String[] args){
		double x=0;
		x = Double.parseDouble(args[0]);
		if (x>0) {
			double s = 0;
			double b= -1;
			for(double i=x; i>=1; i--) {
				s = x / (i + 1 + s);
				s = i + s;
				
			}
			System.out.println(s);


		} else {
			System.out.println("STOP RIGHT THERE CRIMINAL SCUM!");
		}
	}
}