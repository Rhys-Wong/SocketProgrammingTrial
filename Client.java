import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = null;
        InputStreamReader input = null;
        OutputStreamWriter output = null;
        BufferedWriter brw = null;
        BufferedReader brr = null;

        try{
            s = new Socket("localhost",4999);
            input = new InputStreamReader(s.getInputStream());
            output = new OutputStreamWriter(s.getOutputStream());
            brw = new BufferedWriter(output);
            brr = new BufferedReader(input);

            Scanner sc = new Scanner(System.in);

            while(true){

                String msgtosend = sc.nextLine();
                brw.write(msgtosend);
                brw.newLine();
                brw.flush();
                

                System.out.println("Server : " + brr.readLine());

                if(msgtosend.equalsIgnoreCase("Disconnect")){
                    break;
                }
            } 
        }
        catch (IOException e){
            e.printStackTrace();
        } 
        finally {
            try {
                if(s != null){
                    s.close();
                }
                if(input != null){
                    input.close();
                }
                if(output != null){
                    output.close();
                }
                if(brw != null){
                    brw.close();
                }
                if(brr != null){
                    brr.close();
                }
                    
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        
    }
}
