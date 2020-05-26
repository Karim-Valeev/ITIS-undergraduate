package ru.kpfu.itis.valeev;

import java.io.IOException;
import java.util.regex.Matcher;

public interface Command {
    void execute(String command, Matcher m, CommandExecutor ce) throws IOException;
}



