public class Task8{
	
	public static void main(String[] args){
		
		int x=0;
		int k = 0;
		x = Integer.parseInt(args[0]);
		if (x>0) {
			double s = 0;
			for(double i=x; i>=1; i--) {
				s = Math.cos(x + Math.cos(x+s));
				
			}
			
			System.out.println(s);
			System.out.println();
			System.out.println(cosCalc(x));
			System.out.println();
			System.out.println(cosRec(x,k));



		} else {
			System.out.println("STOP RIGHT THERE CRIMINAL SCUM!");
		}
	}

	public static Double cosCalc(int n) {
		double w = 0;
			for(double i=n; i>=1; i--) {
				w = Math.cos(n + Math.cos(n+w));
			}
		return w;
	}

	public static Double cosRec(int n, int k) {
		if (k<=n) {
			k++;
			return Math.cos(n + cosRec(n,k));
		}
		return 0.0;
	}

}


