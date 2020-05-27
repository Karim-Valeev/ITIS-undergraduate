package ru.kpfu.itis.valeev;

public class Karatsuba {

    private static long multiply(long x, long y) {
        if (x<10 || y<10) return x * y;

        String xString = Long.toString(x);
        String yString = Long.toString(y);
        long m1 = Math.max(xString.length(), yString.length());
        long m2 = m1/2;
        long high1 = Long.parseLong(xString.substring(0, (int) (xString.length()-m2)));
        long low1 = Long.parseLong(xString.substring((int) (xString.length()-m2)));
        long high2 = Long.parseLong(yString.substring(0, (int) (yString.length()-m2)));
        long low2 = Long.parseLong(yString.substring((int) (yString.length()-m2)));
        long z0 = multiply(low1, low2);
        long z2 = multiply(high1, high2);
        long z1 = multiply((low1 + high1), (low2 + high2)) - z2 - z0;

        return (long) (z2 * Math.pow(10, 2*m2) + (z1 * Math.pow(10, m2)) + z0);

    }

    public static void main(String[] args) {

        System.out.println(multiply(500, 500));
        System.out.println(500 * 500);
        System.out.println(multiply(12345, 6789));
        System.out.println(12345* 6789);
        System.out.println(multiply(235892567, 12591767));
        System.out.println(235892567L * 12591767);
//        40000
//        83810205
//        2970297027950

    }

}
