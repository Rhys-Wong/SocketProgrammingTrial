import java.io.*;
import java.net.*;
import java.util.*;


public class Client {
    public static void main(String args[]) throws IOException{
        Socket s = new Socket("localhost", 4999);
        

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Hello World! This is a test!");
        pr.flush();

        InputStreamReader input = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(input);

        String str = br.readLine();

        System.out.println("Server : " + str);

    }
    
    
}
