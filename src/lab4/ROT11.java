package lab4;

import java.io.PrintStream;
import java.lang.String;
import java.util.concurrent.Callable;

public class ROT11 implements Algorithm {

    @Override
    public String crypt(String inOneWord) {/*dziala na duzch i malych liter */
        String cryptWord="";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] nowe = inOneWord.toCharArray();
        int move=11;

        for (int i = 0; i < nowe.length; i++)
        {
            for(int j=0;j<alphabet.length;j++)
            {
                if(nowe[i] == alphabet[j])
                {
                    if(j<15)
                    {
                        cryptWord=cryptWord+alphabet[j+move];
                    }
                    else if(j>25&&j<40)
                    {
                        cryptWord=cryptWord+alphabet[j+move];
                    }
                    else if(j>=40)
                    {
                        cryptWord=cryptWord+alphabet[j-15];
                    }
                    else
                    {
                        cryptWord=cryptWord+alphabet[j+move-26];
                    }
                }
            }
        }
        return cryptWord;
    }

    @Override
    public String decrypt(String inOneWord) { /*dziala na duzch i malych liter */
        String decryptWord="";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] nowe = inOneWord.toCharArray();
        int move=11;

        for (int i = 0; i < nowe.length; i++)
        {
            for(int j=0;j<alphabet.length;j++)
            {
                if(nowe[i] == alphabet[j])
                {
                    if(j<11)
                    {
                        decryptWord=decryptWord+alphabet[Math.abs(j-move+26)];
                    }
                    else if(j>=40)
                    {
                        decryptWord=decryptWord+alphabet[j-move];
                    }
                    else if(j>25&&j<40)
                    {
                        decryptWord=decryptWord+alphabet[alphabet.length-(Math.abs(j-26-move))];
                    }
                    else
                    {
                        decryptWord=decryptWord+alphabet[j-move];
                    }

                }
            }
        }
        return decryptWord;
    }
}
