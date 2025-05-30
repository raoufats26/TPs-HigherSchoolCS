package org.isi.exo_4;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurPoste {
    private static Joueur[] joueurs = {
            new Joueur(7, "Mahrez", 32, "Ailier droit"),
            new Joueur(10, "Paul Pogba", 36, "Milieu"),
            new Joueur(7, "Ronaldo", 39, "Attaquant")
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1236)) {
            System.out.println("Serveur Poste en cours d'exécution...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connecté pour recherche par poste");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String request = reader.readLine();

                    ArrayList<Joueur> joueursTrouves = findByPoste(request);
                    writer.write("Joueurs au poste de " + request + ":\n");
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

    private static ArrayList<Joueur> findByPoste(String poste) {
        ArrayList<Joueur> result = new ArrayList<>();
        for (Joueur joueur : joueurs) {
            if (joueur.getPoste().equalsIgnoreCase(poste)) {
                result.add(joueur);
            }
        }
        return result;
    }
}
