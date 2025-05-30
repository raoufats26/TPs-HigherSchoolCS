package org.isi.exo_2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            serverSocket = new ServerSocket(1234);

            socket = serverSocket.accept();
            System.out.println("Connected Successfully!");

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            int number = (int) (Math.random() * 100);

            while (true) {
                int suggestedNum = parseInt(bufferedReader.readLine());

                if (number < suggestedNum) {
                    bufferedWriter.write("Suggest a LOWER Number!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (number > suggestedNum) {
                    bufferedWriter.write("Suggest a HIGHER Number!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else {
                    break;
                }
            }

            bufferedWriter.write("Congratulations! The Number is: " + number);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (outputStreamWriter != null) outputStreamWriter.close();
                if (bufferedReader != null) bufferedReader.close();
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
