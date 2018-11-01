package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {

        File in = new File(argv[0]);

        PrintWriter out = null;

        try {
            out = new PrintWriter(argv[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte szyfrDeszyfr = 0;
        byte algorytm = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("1.ROT11");
        System.out.println("2.Polibiusz");
        String wybor = scan.nextLine();



        if(wybor.equals("1")) algorytm = 1;
        else if (wybor.equals("2")) algorytm = 2;

        System.out.println("1.Szyfrowanie");
        System.out.println("2.Deszydrowanie");

        wybor = scan.nextLine();

        if(wybor.equals("1")) szyfrDeszyfr = 1;
        else if (wybor.equals("2")) szyfrDeszyfr = 2;

        if(algorytm == 1)
        {
            if(szyfrDeszyfr == 1)
            {
                Cryptographer.cryptfile(in, out, new ROT11());
            }
            else if(szyfrDeszyfr == 2)
            {
                Cryptographer.decryptfile(in, out, new ROT11());
            }
        }
       else if(algorytm == 2)
       {
            if(szyfrDeszyfr == 1)
            {
                Cryptographer.cryptfile(in, out, new Polibiusz());
            }
            else if(szyfrDeszyfr == 2)
            {
                Cryptographer.decryptfile(in, out, new Polibiusz());
            }
        }
        else System.out.printf("Blad!");
    }
}