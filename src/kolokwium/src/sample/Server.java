package sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static int PORT = 5555;
    public static boolean flaga = true;
    private static ServerSocket myServerSocket;
    private static Socket ClientSocket;


    public static void main (String[] args) throws IOException
    {

        myServerSocket = null;
        try
        {
            myServerSocket = new ServerSocket(PORT);
        }
        catch(IOException e)
        {
            System.err.println("Nie mozna polaczyc na porcie "+PORT);
            System.exit(1);
        }

        System.out.print("Waiting for client...");

        Thread t = new Thread(new Runnable(){
            public void run()
            {
                try
                {
                    while(flaga)
                    {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                }
                catch(InterruptedException ie)
                {
                    //
                }
                System.out.println("Client connected(port) " + PORT);

            }
        });
        t.start();


        ClientSocket = null;
        try
        {
            ClientSocket = myServerSocket.accept();
            flaga=false;
        }
        catch(IOException e)
        {
            System.err.println("Nie udalo sie!");
            t.interrupt();
            System.exit(1);
        }

        final PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(),true);
        final BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
        Scanner pisz = new Scanner(System.in);
        String a="";


        t=new Thread(new Runnable(){
            public void run()
            {
                try
                {
                    while (true)
                    {
                        String a="";
                        System.out.print("Serwer write: ");
                        a = pisz.nextLine();
                        out.println(a);
                        String input = in.readLine();
                        if(input != null)
                        {
                            System.out.println("Klient: "+input);
                            if(input.equals("STOP"))
                            {
                                System.out.println(System.currentTimeMillis()+" Wrong answer");
                                out.println("STOP");
                                out.close();
                                in.close();
                                ClientSocket.close();
                                myServerSocket.close();
                                break;
                            }
                        }
                        else
                        {
                        }
                    }
                }
                catch(Exception e)
                {
                    System.err.println("Nieoczekiwany blad!");
                }
            }
        });
        t.start();
    }
}
