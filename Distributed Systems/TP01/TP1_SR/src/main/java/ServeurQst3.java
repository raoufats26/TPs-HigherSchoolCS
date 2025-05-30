import java.io.*;
import java.net.*;

public class ServeurQst3 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(7777)) {
            System.out.println("Serveur connecte ");
            try (Socket sock = server.accept()) {
                InputStream input = sock.getInputStream();
                OutputStream output = sock.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

                String mot = reader.readLine();

                String motMajuscule = mot.toUpperCase();

                writer.write(motMajuscule);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
