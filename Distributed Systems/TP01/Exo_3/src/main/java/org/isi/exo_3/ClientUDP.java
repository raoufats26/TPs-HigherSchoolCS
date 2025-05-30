package org.isi.exo_3;
import java.net.*;

public class ClientUDP {
    byte buffer[] = new byte[1024];

    public static void main(String argv[]) throws Exception {
        InetAddress serveur = InetAddress.getByName("localhost");

        int[] tab = {1, 5, 6, 3, 7, 11, 10, 12};

        byte[] buffer = new byte[tab.length * 4];
        for (int i = 0; i < tab.length; i++) {
            buffer[i * 4] = (byte) (tab[i] >> 24);
            buffer[i * 4 + 1] = (byte) (tab[i] >> 16);
            buffer[i * 4 + 2] = (byte) (tab[i] >> 8);
            buffer[i * 4 + 3] = (byte) (tab[i]);
        }

        DatagramPacket donnerEnvoyer = new DatagramPacket(buffer, buffer.length, serveur, 1000);
        DatagramSocket socket = new DatagramSocket();
        socket.send(donnerEnvoyer);

        DatagramPacket donnerRecu = new DatagramPacket(new byte[1024], 1024);
        socket.receive(donnerRecu);

        byte[] receivedData = donnerRecu.getData();
        int[] evenNumbers = new int[donnerRecu.getLength() / 4];
        for (int i = 0; i < evenNumbers.length; i++) {
            evenNumbers[i] = ((receivedData[i * 4] & 0xFF) << 24)
                    | ((receivedData[i * 4 + 1] & 0xFF) << 16)
                    | ((receivedData[i * 4 + 2] & 0xFF) << 8)
                    | (receivedData[i * 4 + 3] & 0xFF);
        }

        System.out.println("Entiers pairs recus : ");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("De : " + donnerRecu.getAddress() + ":" + donnerRecu.getPort());
    }
}
