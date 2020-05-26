package ru.kpfu.itis.valeev;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private String command;
    private CommandExecutor commandExecutor;

    public App(){
        commandExecutor = new CommandExecutor();
    }

    public void init() throws IOException {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.printf("%s$ ",commandExecutor.getCurrentDir());
            command = sc.nextLine();
            commandExecutor.execute(command);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        try {
            app.init();
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

}
