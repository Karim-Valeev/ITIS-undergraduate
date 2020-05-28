package ru.kpfu.itis.valeev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {

    public static final String URL = "https://r3---sn-25glen7l.googlevideo.com/videoplayback?expire=1590511607&ei=l_PMXtWiLsmOmLAP9fCDoAg&ip=51.158.107.202&id=o-AKvJYXWIoo53gem_sxj3x8nOY_5m5JeyToSS6IhgSXZk&itag=22&source=youtube&requiressl=yes&mh=92&mm=31%2C26&mn=sn-25glen7l%2Csn-h5q7knel&ms=au%2Conr&mv=m&mvi=2&pl=24&initcwndbps=850000&vprv=1&mime=video%2Fmp4&ratebypass=yes&dur=923.713&lmt=1586836485214907&mt=1590489933&fvip=3&c=WEB&txp=5432432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhALuxX2hrvoQdYXrF8tgSpzIken5YucAvuG4h--GcNKosAiAXBbqmOxcBEbJnQsiaSmKQRwVoveJeYDm9SFZmnQTRwQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgBWbQlZHVjOx9HargDEGc_G1WROcWa9vEg4HanmlXGGQCIQCDZANlXjX059iOeOKr_LeOEBug--PhTtiETE-Z0ao9nw%3D%3D&contentlength=20824495&video_id=ZDa-Z5JzLYM&title=Python+OOP+Tutorial+1-+Classes+and+Instances";
    public static final long SIZE = 8674318;
    public static int counter = 0;

    public static void main(String[] args) {

        CommandExecuter ce = new CommandExecuter(URL);
        Thread commandExecuteThread = new Thread(ce);
        commandExecuteThread.start();

    }

}
