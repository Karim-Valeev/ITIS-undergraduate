public class Task2{
	public static void main(String[] args){
		double r = 0;
		r = Double.parseDouble(args[0]);
		if (r>0) {
			System.out.println(2*3.14*r);
			System.out.println(3.14*r*r);
		} else {
			System.out.println("Input something bigger than zero.");
		}
	}
}