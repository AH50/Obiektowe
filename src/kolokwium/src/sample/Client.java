package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {



    private static final int PORT = 5555;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        Socket socket = null;

        try
        {
            socket = new Socket(HOST, PORT);
        }
        catch(Exception e)
        {
            System.err.println("Connection problem(host,port): "+HOST+":"+PORT);
            System.exit(1);
        }



        final PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner write = new Scanner(System.in);

        Thread t = new Thread(new Runnable()
        {
            public void run()
            {

                while (true)
                {
                    try
                    {
                        String input = in.readLine();
                        if (input != null)
                        {
                            System.out.println( "Server napisal: " + input);
                            if(input.equals("STOP"))
                            {
                                System.out.println(System.currentTimeMillis()+"Zla odpowiedz");
                                out.println("STOP");
                                out.close();
                                in.close();
                                break;
                            }
                            String a="";
                            System.out.print("Klient pisze: ");
                            a = write.nextLine();
                            out.println(a);
                        }
                    }
                    catch (IOException ioe)
                    {
                        //
                    }
                }

            }
        });
        t.start();
    }
}
