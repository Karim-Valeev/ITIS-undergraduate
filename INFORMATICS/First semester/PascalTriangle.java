public class PascalTriangle {

    public static void main(String[] args) {
    
        System.out.println("Enter positive integer.");
        int h = Integer.parseInt(args[0]);

        if (h>0) {

            int length = String.valueOf(h*h*h).length();

            for(int i =0;i<h;i++) {
                int n = 1;
                System.out.format("%"+(h-i)*2+"s","");
                
                for(int j=0;j<=i;j++) {
                    System.out.format("%" + length + "d",n);
                    
                    n = n * (i - j) / (j + 1);

                }
            System.out.println();
            }


        } else {

            System.out.println("Please, enter positive integer. ");
    
        }

    }

}