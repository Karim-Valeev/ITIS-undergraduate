package ru.kpfu.itis.valeev;

import java.util.Scanner;
import java.util.regex.*;

public class RegExTester {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String text = sc.nextLine();
        String text = "ha-ha.com AAAAAAAA ass.s  -abc-.org AAAAAAA asdasdasd.com.ru";

        // Task 12.2-12.3:
        Pattern p = Pattern.compile("([a-zA-Z0-9][a-zA-Z0-9-]{0,61}[a-zA-Z0-9](\\.[a-zA-Z0-9][a-zA-Z0-9-]{0,61}[a-zA-Z  0-9])+)");
        // Как ограничить это регулярное выражение 255-ью символа сохранив условие
        Matcher m1 = p.matcher(text);
        Matcher m2 = p.matcher(text);

        // Task 12.2:
        System.out.println("Typed string is domain name: " + m1.find() + "\n");

        // Task 12.3:
        while (m2.find()) {
            System.out.println(m2.group());
        }
        System.out.println();

        // Task 12.4:
        String text1 = "RegEx pretty useful thing, karim.valeev.i@gmail.mmm.com, 123@yandex.taxi.ru";

        Pattern p2 = Pattern.compile("[a-zA-Z0-9]([a-zA-Z0-9]|[a-zA-Z0-9-\\._][a-zA-Z0-9])*@([a-z0-9][a-z0-9-]{0,61}[a-z0-9])\\.([a-z0-9][a-z0-9-]{0,61}[a-z0-9\\.])*([a-z0-9][a-z0-9-]{0,61}[a-z0-9])");
        // Не для всех возможных условий, пощадите :(
        // !#$%&'*+-/=?^_`{|}~ такие символы многие компании не разрешают
        //  IP адреса вместо доменных имен отправляют только спам (написано на вики)
        Matcher m = p2.matcher(text1);


        while (m.find()) {
            System.out.println("Upper level of domain: " + m.group(2));
            System.out.println("Lower level of domain: " + m.group(4) + "\n");
//
        }

    }
}
