package EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 2391;
        ServerSocket serverSocket =null;
        System.out.println("2");
        try{
           serverSocket= new ServerSocket(8899);



        }catch (IOException e){
            System.out.println("—Cant listen on portr number 8899");
            System.exit(-1);
        }
        Socket clientSocker=null;
        System.out.println("+Listen for connection...");
        try {
            clientSocker=serverSocket.accept();
        }catch (IOException e){
            System.out.println("—Fail");
            System.exit(-1);
        }
        System.out.println("+Connection successful");
        System.out.println("+Listening for input");

        PrintWriter output= new PrintWriter(clientSocker.getOutputStream(),true);
        BufferedReader input= new BufferedReader(new InputStreamReader(clientSocker.getInputStream()));

        String inputLine;
        while ((inputLine=input.readLine())!= null){
            System.out.println("Server"+ inputLine);
            output.println(inputLine);

            if (inputLine.equals("break")){
                break;
            }
        }
        //
        output.close();
        input.close();
        clientSocker.close();
        serverSocket.close();
    }
}
