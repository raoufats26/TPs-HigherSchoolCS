package org.isi.exo_4;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientAge {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur pour recherche par âge. Entrez un âge:");
            String request = scanner.nextLine();
            writer.write(request);
            writer.newLine();
            writer.flush();

            String serverResponse;
            while ((serverResponse = reader.readLine()) != null) {
                System.out.println(serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
