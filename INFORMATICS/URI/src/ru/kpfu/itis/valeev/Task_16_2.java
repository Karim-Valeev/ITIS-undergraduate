package ru.kpfu.itis.valeev;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_16_2 {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL adress, if you want to copy all hyperlinks from the web page:");
        String link = sc.nextLine();
        try{
            URI uri = new URI(link);
            BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));

            String line;
            StringBuilder lines = new StringBuilder();
            while((line = in.readLine()) != null){
                lines.append(line);
            }

            //Pattern p1 = Pattern.compile("<p>([0-9А-Яа-я\\.,:;\\- \\[\\]\\{\\}\\(\\)]+).*<\\/p>");
            Pattern p2 = Pattern.compile("<a href=\"(.+?)\".*?>");
            //Matcher m1 = p1.matcher(lines);
            Matcher m2 = p2.matcher(lines);

            try(FileWriter fw = new FileWriter("hyperlinks.txt")){

                while (m2.find()) {
                    String str = m2.group(1);
                    fw.write(str + "\n"+"\n");
                }

            }catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        } catch(URISyntaxException ex){
            System.err.print("Incorrect URL.");
        }

    }
}
