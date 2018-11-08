package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delay {
    public static void delaySubtitles(File input, PrintWriter outFile, int delay, int fps)
            throws InvalidFormat, IllegalArgumentException, FileNotFoundException {

        Scanner scan = new Scanner(input);
        Pattern pattern = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.*)");

        int nrLine=0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Matcher match = pattern.matcher(line);
            StringBuilder result = new StringBuilder();
            if (match.find()) {
                int start = Integer.parseInt(match.group(1)) + (delay * fps / 1000);
                int end = Integer.parseInt(match.group(2)) + (delay * fps / 1000);
                nrLine=nrLine+1;
                if (end < start)
                {
                    throw new InvalidFormat(line,nrLine);
                }
                result.append("{").append(start).append("}{").append(end).append("}").append(match.group(3));

                outFile.println(result.toString());
            } else throw new InvalidFormat(line,nrLine);
        }
    }
}