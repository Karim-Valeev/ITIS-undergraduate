package ru.kpfu.itis.valeev;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
import java.util.Scanner;

public class SoundTester {

    public static void main(String[] args) {

        HashMap<Character,Integer> notes = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = 36;
        for(int j=97; j<124;j++){
            notes.put((char) j,n++);
        }

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            MidiChannel[] channels = synth.getChannels();
            channels[0].programChange(1);

            String buff;
            while (true){

                buff = sc.nextLine();

                if(!buff.equals("exit")){
                    synth.open();
                    channels[0].noteOn(notes.get(buff.charAt(0)), 80);
                    Thread.sleep(1000);
                    channels[0].noteOff(65);
                    synth.close();

                } else {
                    System.out.println("Bye-bye!");
                    System.exit(0);
                }
            }

        }  catch (MidiUnavailableException | InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
