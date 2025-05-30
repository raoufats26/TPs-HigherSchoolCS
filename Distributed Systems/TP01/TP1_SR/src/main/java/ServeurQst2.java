import java.io.*;
import java.net.*;

public class ServeurQst2 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Serveur connecte ");
            try (Socket sock = server.accept()) {
                InputStream input = sock.getInputStream();
                OutputStream output = sock.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

                int nbre = Integer.parseInt(reader.readLine());

                for (int i = 0; i <= 10; i++) {
                    writer.write((nbre * i)+"  ");
                    writer.flush();
                }
                writer.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
