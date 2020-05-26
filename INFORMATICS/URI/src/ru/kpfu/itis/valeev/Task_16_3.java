package ru.kpfu.itis.valeev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_16_3 {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL adress, if you want to count the amount of images and <div></div> elements:");
        String link = sc.nextLine();
        try{
            URI uri = new URI(link);
            BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));

            String line;
            StringBuilder lines = new StringBuilder();
            while((line = in.readLine()) != null){
                lines.append(line);
            }

            Pattern p1 = Pattern.compile("(<img )");
            Pattern p2 = Pattern.compile("(<svg role=\"img\">)");


            Matcher m1 = p1.matcher(lines);
            Matcher m2 = p2.matcher(lines);

            int c = 0;
            while (m1.find()) {
                c++; // в итоге вернет то же самое b и быстрее
                // c += m1.groupCount(); работает, но медленно
            }
            while (m2.find()) {
                c++;
            }
            System.out.print("\n" +"Web page has "+ c + " images and ");

            c=0;
            Pattern p3 = Pattern.compile("(</div>)");
            Matcher m3 = p3.matcher(lines);
            while (m3.find()) {
                c++;
            }
            System.out.print(c + " <div></div> elements.");

        } catch(URISyntaxException ex){
            System.err.print("Incorrect URL.");
        }

    }

}
