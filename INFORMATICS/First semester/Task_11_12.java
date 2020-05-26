public class Task_11_12{
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		if (n>1) {
			for(int i = 1; i <= n; i++){
				for (int k=1 ; k <= n; k++){
					System.out.print(k * i + " ");
				}
				System.out.print("\n");
			}

			System.out.println();

			int length = String.valueOf(n*n).length();
			length++;
			for(int i = 1; i <= n; i++){
				for (int k=1 ; k <= n; k++){
					System.out.printf("%"+length+"d", k * i," ");
				}
				System.out.print("\n");
			}
			

		} else {
			System.out.print(1);
		}
	}
}