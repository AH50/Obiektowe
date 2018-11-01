package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File in, PrintWriter out, Algorithm algorithm){


        Scanner scan = null;

        try {
            scan = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {

            Scanner scan2 = new Scanner(scan.nextLine());

            while (scan2.hasNext()) {
                String tmp = scan2.next();
                out.print(algorithm.crypt(tmp));
                out.print(" ");
            }
            out.println();
        }
        out.close();
    }
    public static void decryptfile(File in, PrintWriter out, Algorithm algorithm){

        Scanner scan = null;

        try {
            scan = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {

            Scanner scan2 = new Scanner(scan.nextLine());

            while (scan2.hasNext()) {
                String tmp = scan2.next();
                out.print(algorithm.decrypt(tmp));
                out.print(" ");
            }
            out.println();
        }
        out.close();
    }
}