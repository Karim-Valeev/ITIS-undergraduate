package ru.kpfu.itis.valeev;

import java.util.Scanner;

public class CommandExecuter implements Runnable{

    public String url;

    public CommandExecuter(String url){
        this.url = url;
    }

    @Override
    public void run() {
        execute();
    }

    public void execute(){
        Scanner sc = new Scanner(System.in);
        Downloader d = new Downloader();
        Thread downloader = new Thread(d);
        while (true) {
            String command = sc.nextLine();
            switch (command) {
                case "start":
                    downloader.start();
                    System.out.println("Download started...");
                    break;
                case "status":
                    System.out.println(FileDownloader.counter + "/" + FileDownloader.SIZE + " bytes");
                    break;
                case "exit":
                    if(FileDownloader.counter < FileDownloader.SIZE){
                        System.out.println("You have not finished downloading! Do you want to continue?");
                        System.out.print("Yes/No: ");
                        String buff = sc.nextLine();
                        if(buff.equals("Yes")){
                            System.out.println("Continue downloading...");
                            continue;
                        } else {
                            System.out.println("Bye-bye!");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Bye-bye!");
                        System.exit(0);
                    }
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }

}
