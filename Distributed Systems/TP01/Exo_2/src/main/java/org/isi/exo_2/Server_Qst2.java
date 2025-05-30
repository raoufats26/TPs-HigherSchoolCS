package org.isi.exo_2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class Server_Qst2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        int number = (int) (Math.random() * 100);
        System.out.println("The number to guess is: " + number);

        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is running... Waiting for clients.");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                new Thread(new ClientHandler(socket, number)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private int number;

    public ClientHandler(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }

    @Override
    public void run() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String response;
            while (true) {
                int suggestedNum = Integer.parseInt(bufferedReader.readLine());

                if (number < suggestedNum) {
                    bufferedWriter.write("Suggest a LOWER Number!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (number > suggestedNum) {
                    bufferedWriter.write("Suggest a HIGHER Number!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else {
                    bufferedWriter.write("Congratulations! The Number is: " + number);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }
            }
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
