package ru.kpfu.itis.valeev;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands{

    //Полиморфизм во всей красе

    CD(Pattern.compile("^cd *"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
                ce.setCurrentDir(new File("/"));
            }
        }
    }),
    CD_PATH(Pattern.compile("^cd (.+)"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
                File file = new File(m.group(1));
                file = new File(String.valueOf(ce.getCurrentDir().toPath().resolve(file.toPath())));
                if(file.isFile()){
                    System.out.println("Not a directory");
                } else if((file).exists() && file.isDirectory()){
                    ce.setCurrentDir(file);
                } else {
                    System.out.println("No such file or directory");
                }
            }
        }
    }),
    LS(Pattern.compile("^ls *"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            File[] files = ce.getCurrentDir().listFiles();
            for(int i = 0; i<files.length;i++){
                System.out.println(files[i].getName());
            }
        }
    }),
    OPEN(Pattern.compile("^open (.+)"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
//                File file = new File(m.group(1));
//                if(file.exists()){
//                    Desktop desktop = Desktop.getDesktop();
//                    desktop.open(file);
//                } else{
//                    System.out.println("Something wrong happened");
//                }
                File file = new File(m.group(1));
                if(file.exists() && file.isFile()){
                    String mimeType = Files.probeContentType(file.toPath());
                    if(mimeType == null){
                        System.out.println("Unknown type");
                        return;
                    }
                    Matcher matcher = Pattern.compile("(.+)/.+").matcher(mimeType);
                    matcher.matches();
                    String type = matcher.group(1);
                    String[] cmd;
                    Process p;

                    if(type.equals("image") || type.equals("text") || type.equals("video")){
                        cmd = new String[]{
                                "xdg-open",
                                file.getPath()
                        };
                        p = Runtime.getRuntime().exec(cmd);
                    } else if(type.equals("application")){
                        cmd = new String[]{
                                "open",
                                file.getPath()
                        };
                        p = Runtime.getRuntime().exec(cmd);
                    }
                } else {
                    System.out.println("No such file");
                }
            }
        }
    }),
    COPY_PASTE(Pattern.compile("^copy (.+) to (.+)"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
                File file = new File(String.valueOf(ce.getCurrentDir().toPath().resolve(m.group(1))));
                File toPath = new File(String.valueOf(ce.getCurrentDir().toPath().resolve(m.group(2))));
                if(file.exists() && toPath.exists()) {
                    SpecialCommands.copy(file,toPath.toPath());
                    System.out.printf("%s has been copied \n",file);
                }else{
                    System.out.println("Incorrect arguments");
                }
            }
        }
    }),
    DELETE(Pattern.compile("^delete (.+)"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
                File file = new File(String.valueOf(ce.getCurrentDir().toPath().resolve(m.group(1))));
                String str = file.getPath();
                if(!file.exists()) {
                    SpecialCommands.delete(file);
                    System.out.println(str + " has been deleted");
                }else{
                    System.out.println("Something wrong happened");
                }
            }
        }
    }),
    CAT(Pattern.compile("^cat (.+) with encoding (.+)"), new Command() {
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            if(m.matches()){
                File file = new File(String.valueOf(ce.getCurrentDir().toPath().resolve(m.group(1))));
                try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName(m.group(2))))){
                    while (br.ready()){
                        System.out.println(br.readLine());
                    }
                } catch (FileNotFoundException | UnsupportedEncodingException ex){
                    ex.printStackTrace();
                }
            }
        }
    }),
    EXIT(Pattern.compile("^exit *"), new Command() { // DONE
        @Override
        public void execute(String command, Matcher m, CommandExecutor ce) throws IOException {
            System.out.printf("Bye-bye, %s!",System.getProperty("user.name"));
            System.exit(0);
        }
    });

    private Pattern pattern;
    private Command command;

    Commands(Pattern pattern, Command command) {
        this.pattern = pattern;
        this.command = command;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Command getCommand() {
        return command;
    }

}
