package ru.kpfu.itis.valeev;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    //{"domain": "my-facebook-wise-public-money-business.com",
    // "create_date": "2020-05-11T07:32:06.733639",
    // "update_date": "2020-05-11T07:32:06.733642",
    // "country": null, "isDead": "False", "A": null, "NS": null, "CNAME": null, "MX": null, "TXT": null}

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("app.properties");
        fw.write("app.link = https://domainsdb.info/");
        fw.close();



        System.out.print("Enter the word with which you would like to get a domain name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String link = "https://api.domainsdb.info/v1/domains/search?domain=" + name +"&zone=com";


        try{
            URLConnection connection = new URL(link).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader in  = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder lines = new StringBuilder();
            while((line = in.readLine()) != null){
                lines.append(line);
            }

            String[][] l = new String[50][3];

            //ToDO работу с   json
            Pattern p = Pattern.compile("\"domain\": \"(.+?)\", \"create_date\": \"(.+?)\", \"update_date\": \"(.+?)\"");
            //Matcher m1 = p1.matcher(lines);
            Matcher m = p.matcher(lines);
            int j = 0;
            while (m.find()) {
                l[j][0] = m.group(1);
                l[j][1] = m.group(2);
                l[j][2] = m.group(3);
                j++;
            }

            Arrays.sort(l, Comparator.comparing(b -> LocalDateTime.parse(b[1], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"))));

            fw = new FileWriter("names.csv");
            fw.write("domain;create_date;update_date \n");
            for(int i = 0; i<50; i++){
                fw.write(l[i][0] + ";");
                fw.write(l[i][1] + ";");
                fw.write(l[i][2] + "\n");
            }
            fw.close();

        } catch(MalformedURLException ex){
            ex.printStackTrace();
        }
    }
}
