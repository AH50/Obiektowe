package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static lab5.Delay.delaySubtitles;

public class Main {
    public static void main(String[] args){

        PrintWriter outFile = null;
        int fps = 0;
        int delay = 0;
        File inFile = null;
        try {
            inFile = new File(args[0]);
            outFile = new PrintWriter(args[1]);
            delay= Integer.parseInt(args[2]);
            fps= Integer.parseInt(args[3]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(fps<0)
        {
            System.err.println("Fps nie moga byc ujemne!!!");
        }
        else {
            try {
                delaySubtitles(inFile,outFile,delay,fps);
            } catch (InvalidFormat invalidFormat) {
                System.out.println(invalidFormat.getMessage());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
