package org.isi.exo_1;
import java.io.*;
import java.net.*;

public class RPCServer {
    public int multiplication(int a, int b) {
        return a * b;
    }
    public int addition(int a, int b) {
        return a + b;
    }
    public float division(float a, float b) {
        return a / b;
    }


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Serveur RPC en cours d'execution sur le port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String request = in.readLine();
                int a = Integer.parseInt(in.readLine());
                int b = Integer.parseInt(in.readLine());
                switch (request.toLowerCase()){
                    case "multiplication": {
                        int result = new RPCServer().multiplication(a, b);
                        out.println(String.valueOf(result));}
                    case "addition": {
                        int result = new RPCServer().addition(a, b);
                        out.println(String.valueOf(result));}
                    case "soustraction": {
                        int result = new RPCServer().addition(a, -b);
                        out.println(String.valueOf(result));}
                    case "division": {

                            float result = new RPCServer().division(a, b);
                            String formatted = String.format("%.2f", result);
                            out.println(formatted);

                        }

                }
                clientSocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}