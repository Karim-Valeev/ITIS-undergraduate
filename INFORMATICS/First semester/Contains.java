import java.util.Scanner;

public class Contains {
 	public static void main(String[] args) {
  		Scanner scnr = new Scanner(System.in);
  		String str = scnr.next();
  		String pattern = scnr.next();
  		int n1 = str.length(),  k = 0, n2 = pattern.length(), jj;
  		System.out.println();
  		boolean flag = false;
  
  		for (int i = 0; i < n1; i++) {
   			if (str.charAt(i) == pattern.charAt(0)) {
   				k = i;
    			for (int j = 0; j < n2; j++) {

     				if (i + n2 > n1) {
     					flag = false;
     					break;
     				}

     				if (str.charAt(k) == pattern.charAt(j)) {
     					k++;
     				} else {
     					flag = false;
     					break;
     				}
     				
     				jj = j;
     				if (jj == n2-1) {
     			 		flag = true;
     				}
     			}
    		}
   		}
  		
  		System.out.println(flag);
  		System.out.println(str.contains(pattern));
 
  
 	}
}
