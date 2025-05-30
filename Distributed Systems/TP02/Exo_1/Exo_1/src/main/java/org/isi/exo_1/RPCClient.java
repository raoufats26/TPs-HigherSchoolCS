package org.isi.exo_1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Veuillez choisir une operation : ");
            Scanner scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            out.println(operation);
            System.out.println("Veuillez choisir le 1er operande : ");
            out.println(scanner.nextInt());
            System.out.println("Veuillez choisir le 2eme operande : ");
            out.println(scanner.nextInt());
            String result = in.readLine();
            System.out.println("Resultat de la "+operation+" : " + result);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}