/**
 * Created by spoppe on 15.08.2016.
 */

import javax.sound.midi.*;
import javax.swing.*;

public class SequencerTest {
    public void spielen(int instrument, int ton) {


        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();


            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage instrumentenWahl = new ShortMessage();

            /*instrumentenWahl.setMessage(192, 1, 1, 100);
            MidiEvent m1 = new MidiEvent(instrumentenWahl, 1);
            track.add(m1);*/

            ShortMessage ton1 = new ShortMessage();
            ton1.setMessage(144, 1, 44, 1);
            MidiEvent m2 = new MidiEvent(ton1, 1);
            track.add(m2);


            ShortMessage ton2 = new ShortMessage();
            ton2.setMessage(128, 1, 44, 16);
            MidiEvent m3 = new MidiEvent(ton2, 16);
            track.add(m3);


            player.setSequence(seq);


            player.start();
            Thread.sleep(5000);
            player.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static int string2int(String strings) {
        return Integer.parseInt(strings);
    }


    public static void main(String[] args) {


            SequencerTest seqTest = new SequencerTest();
            int instrument = string2int(JOptionPane.showInputDialog("Wählen sie ein Instrument aus! (Integer Zahl)"));
            int ton = string2int(JOptionPane.showInputDialog("Wählen sie einen Ton aus! (Integer Zahl)"));
            seqTest.spielen(instrument, ton);

    }


}
