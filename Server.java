import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {


        Socket s = null;
        InputStreamReader input = null;
        OutputStreamWriter output = null;
        BufferedWriter brw = null;
        BufferedReader brr = null;

        ServerSocket ss = null;
        ss = new ServerSocket(4999);

        while(true){

            try {
                s = ss.accept();

                input = new InputStreamReader(s.getInputStream());
                output = new OutputStreamWriter(s.getOutputStream());
                brw = new BufferedWriter(output);
                brr = new BufferedReader(input);

                while(true){
                    String msgfromclient = brr.readLine();

                    System.out.println("CLient : " + msgfromclient);

                    brw.write("Received you bitch ass!");
                    brw.newLine();
                    brw.flush();

                    if(msgfromclient.equalsIgnoreCase("Disconnect")){
                        break;
                    }

                    
                }
                    s.close();
                    input.close();
                    output.close();
                    brr.close();
                    brw.close();
                
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}
