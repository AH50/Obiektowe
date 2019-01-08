package sample.testowyfolder;

import java.io.*;
import java.net.*;


public class ReadT extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatUser client;

    public ReadT(Socket socket, ChatUser client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                System.out.println("\n" + response);
                if (client.getUserName() != null) {
                    System.out.print("[" + client.getUserName() + "]: ");
                }
            } catch (IOException ex) {
                System.out.println("Error : " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}