import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientQst3 {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 7777)) {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez un mot en minuscule : ");
            String mot = scanner.nextLine();

            writer.write(mot);
            writer.newLine();
            writer.flush();

            String reponse = reader.readLine();
            System.out.println("Reponse du serveur : " + reponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
