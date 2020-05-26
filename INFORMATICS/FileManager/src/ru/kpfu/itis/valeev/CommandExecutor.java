package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

public class CommandExecutor {
    private File currentDir;

    public CommandExecutor(){
        this.currentDir = new File("/");
    }

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File currentDir) {
        this.currentDir = new File(currentDir.toPath().normalize().toString());
    }

    public void execute(String command) throws IOException {
        Matcher m;
        for(Commands c : Commands.values()){
            m = c.getPattern().matcher(command);
            if(m.matches()){
                c.getCommand().execute(command, c.getPattern().matcher(command), this);
                return;
            }
        }
        System.out.printf("Command '%s' not found.\n",command);
    }

}

