package org.isi.clientservermessenger;
import java.io.*;
import java.net.ServerSocket;
import java.util.*;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(1234);

        while (true){
            try {
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){
                    String msgFromClient = bufferedReader.readLine();
                    System.out.println("Client : "+msgFromClient);
                    bufferedWriter.write("Message received!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    if (msgFromClient.equalsIgnoreCase("BYE")) {
                        break;
                    }
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedWriter.close();
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
