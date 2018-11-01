package lab4;

public class Polibiusz implements Algorithm {
    @Override
    public String crypt(String inOneWord) {
        String cryptedWord = "";
        inOneWord = inOneWord.toLowerCase();
         char tab[][] = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'k'},
                {'l', 'm', 'n', 'o', 'p'},
                {'q', 'r', 's', 't', 'u'},
                {'v', 'w', 'x', 'y', 'z'}};

        for (int i = 0; i < inOneWord.length(); i++) {
            char CharToFind = inOneWord.charAt(i);

            if (CharToFind == 'j') CharToFind = 'i';

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (tab[j][k] == CharToFind) {
                        cryptedWord += j + 1;
                        cryptedWord += k + 1;
                    }
                }
            }
        }
        return cryptedWord;
    }

    @Override
    public String decrypt(String inOneWord) {
        String decryptedWord="";
        char tab[][] = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'k'},
                {'l', 'm', 'n', 'o', 'p'},
                {'q', 'r', 's', 't', 'u'},
                {'v', 'w', 'x', 'y', 'z'}};
        char[] nowe = inOneWord.toCharArray();

        for (int i = 0; i < inOneWord.length(); i+=2) {

            decryptedWord = decryptedWord + tab[Integer.parseInt(String.valueOf(nowe[i]))-1][Integer.parseInt(String.valueOf(nowe[i+1]))-1];

        }
        return decryptedWord;
    }
}