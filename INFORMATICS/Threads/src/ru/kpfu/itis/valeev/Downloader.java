package ru.kpfu.itis.valeev;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Downloader implements Runnable{

    @Override
    public void run() {
        execute();
    }

    private void execute(){
        try{
            URLConnection connection = new URL(FileDownloader.URL).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            InputStream in  = connection.getInputStream();
            FileOutputStream out = new FileOutputStream(new File("video.mp4"));
            int buff;
            while ((buff = in.read()) != -1){
                out.write(buff);
                FileDownloader.counter++;
            }
            out.flush();
            out.close();
            System.out.println("File is downloaded!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
