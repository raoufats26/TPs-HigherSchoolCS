import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientQst2 {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int nbre = scanner.nextInt();
            writer.write(String.valueOf(nbre));
            writer.newLine();
            writer.flush();

            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
