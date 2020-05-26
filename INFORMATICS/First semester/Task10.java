public class Task10{
	public static void main(String[] args){
		
		// for frame

		int n = Integer.parseInt(args[0]);

		if (n>1) {
			String str1 = "*";
			for (int i = 2; i <= (n-1); i++) {
				str1 = str1 + "*";
			}
			str1 = str1 +"*";

			String str2 = "*";
			for (int i = 2; i <= (n-1); i++) {
				str2 = str2 + " ";
			}
			str2 = str2 +"*";

			System.out.println(str1);

			for (int i = 2; i <= (n-1); i++) {
				System.out.println(str2);
			}

			System.out.println(str1);
		} else {
			System.out.println('*');
		}

		/*
		
		for square
		
		if (n>1) {
			for (int i = 1; i <= n; i++) {
			System.out.println(str1);
			}
		} else {
			System.out.println('*');
		}
		*/

	}
}