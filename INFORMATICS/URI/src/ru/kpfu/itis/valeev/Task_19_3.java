package ru.kpfu.itis.valeev;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_19_3 {

    //private final int LEVEL = 1;
    private static final File STORAGE = new File("/URI/downloads");

    public static void main(String[] args) throws IOException {
        //https://skillbox.ru/
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the link to the site you would like to download: ");
        String link = sc.nextLine();

        HashSet<String> lib = new HashSet<>();
        lib.add(link);

        File currentDir = createDir(STORAGE,link);
        String lines = downloadSite(link);
        createHTML(currentDir,link,lines);

        if(currentDir.exists()){

            Pattern p = Pattern.compile("<a href=\"(.+?)\".*?>");
            Matcher m = p.matcher(lines);

            File f;
            while (m.find()) {
                String buffLink = m.group(1);
                if(!lib.contains(buffLink)){
                    f = createDir(currentDir,buffLink);
                    System.out.println(f);
                    System.out.println(f.exists());
                    lines = downloadSite(buffLink);
                    createHTML(f,buffLink,lines);
                    lib.add(buffLink);
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("Site downloaded!");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    private static String downloadSite(String link){
        try{
            URLConnection connection = new URL(link).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader br  = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder lines = new StringBuilder();
            while(br.ready()){
                lines.append(br.readLine()).append("\n");
            }
            return lines.toString();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private static void createHTML(File currentDir, String name, String lines){
        try{
            String buff = name.replaceAll("//","_").replaceAll("/","_");
            File f = new File(currentDir.getAbsolutePath() + "/" + buff + ".html");
            FileWriter fw = new FileWriter(f);
            fw.write(lines);
            fw.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static File createDir(File currentDir, String link){
        try{
            String name = link.replaceAll("//","_").replaceAll("/","_");
            File f = new File(currentDir.getName() + "/" + name);
            f.mkdir();
            return f;
        } catch (SecurityException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
