package org.isi.exo_2;
import java.io.*;
import java.util.Scanner;
import java.net.Socket;
public class Client_2 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost",1234);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String response;
            System.out.println("Suggest a number!");
            while (true){
                Scanner scanner = new Scanner(System.in);
                int suggestedNum = scanner.nextInt();
                bufferedWriter.write(String.valueOf(suggestedNum));
                bufferedWriter.newLine();
                bufferedWriter.flush();
                response = bufferedReader.readLine();
                if (response.contains("Congratulations")){
                    System.out.println(response);
                    break;
                }
                System.out.println(response);
            }
            try {
                if (socket != null)
                    socket.close();

            }catch (IOException e){
                e.printStackTrace();
            }


        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
