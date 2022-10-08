import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        //System.out.println("Client accepted! Congrats!");

        InputStreamReader input = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(input);

        String str = br.readLine();
        System.out.println("Client : " + str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Muchas Gracias");
        pr.flush();

    }
    
}
