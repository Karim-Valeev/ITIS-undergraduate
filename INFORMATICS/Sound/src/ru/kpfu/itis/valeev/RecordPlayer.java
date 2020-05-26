package ru.kpfu.itis.valeev;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordPlayer {

    public void record(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of the song in the first line " +
                "\nand sequence of notes you would like to play according to the notesTable in the second:" +
                "\n(-1 equals to pause)");

        String name = sc.nextLine().trim();
        String notes = sc.nextLine().trim();

        try(FileWriter fw = new FileWriter(name+".txt")){
            fw.write(notes);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void play(Path p){

        try {
            File f = new File(p.toString());
            Scanner sc = new Scanner(f);
            String[] buff = sc.nextLine().split(" ");

            Synthesizer synth = MidiSystem.getSynthesizer();
            MidiChannel[] channels = synth.getChannels();
            channels[0].programChange(1);
            synth.open();
            for (String s : buff) {
                if (s.equals("-1")) {
                    Thread.sleep(750);
                } else {
                    channels[0].noteOn(Integer.parseInt(s), 80);
                    Thread.sleep(350);
                    channels[0].noteOff(65);
                }
            }
            synth.close();
        } catch (MidiUnavailableException | InterruptedException | FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

        RecordPlayer rp = new RecordPlayer();
        rp.play(Paths.get("test.txt"));

        //rp.record();
        //Jasper Forks — River Flows In You
        //81 80 81 -1 80 81 69 76 81 69 74 73 74 76 73 71 -1 69 68 69 71 73 -1 73 74 76 -1 69 74 73 71 -1 81 80 81 -1 80 81 69 76 81 69

        rp.play(Paths.get("Jasper Forks — River Flows In You.txt"));
    }
}

