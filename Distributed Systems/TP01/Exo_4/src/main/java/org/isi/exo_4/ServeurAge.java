package org.isi.exo_4;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurAge {
    private static Joueur[] joueurs = {
            new Joueur(7, "Mahrez", 32, "Ailier droit"),
            new Joueur(10, "Paul Pogba", 36, "Milieu"),
            new Joueur(7, "Ronaldo", 39, "Attaquant")
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Serveur Age en cours d'exécution...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connecté pour recherche par âge");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String request = reader.readLine();
                    int age = Integer.parseInt(request);

                    ArrayList<Joueur> joueursTrouves = findByAge(age);
                    writer.write("Joueurs avec l'âge de " + age + ":\n");
                    for (Joueur joueur : joueursTrouves) {
                        writer.write(joueur.toString() + "\n");
                    }
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Joueur> findByAge(int age) {
        ArrayList<Joueur> result = new ArrayList<>();
        for (Joueur joueur : joueurs) {
            if (joueur.getAge() == age) {
                result.add(joueur);
            }
        }
        return result;
    }
}
