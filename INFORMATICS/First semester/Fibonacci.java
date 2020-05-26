public class Fibonacci{
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		if (n>=0) {
			System.out.println(fibonacciRec(n));
			System.out.println();

			int a = 0;
			int b = 1;
			int c = 0;
			int f = 0;
			if (n == 1) {
				System.out.println(a);
			} else if (n==2) {
    			System.out.println(b);
    		} else {
    			for(int i = 3; i <=n; i++) {
    				f = a + b;
    				c = b;
    				b +=a;
    				a = c;
    			}
    			System.out.println(f);
    		}


		} else {
			System.out.println("Input number bigger than zero.");
		}
	}	

	public static int fibonacciRec(int n) {
    	if (n == 1) {
			return 0;
		} else if (n==2) {
    		return 1;
    	} else {
    		return fibonacciRec(n-2) + fibonacciRec(n-1); 
    	}	
    } 
}


