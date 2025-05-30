package org.isi.exo_3;
import java.net.*;
import java.util.*;

class ServeurUDP {
    static byte buffer[] = new byte[1024];

    public static void main(String argv[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(1000);
        while(true) {
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            socket.receive(data);

            byte[] receivedData = data.getData();
            int[] numbers = new int[(data.getLength() / 4)];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = ((receivedData[i * 4] & 0xFF) << 24)
                        | ((receivedData[i * 4 + 1] & 0xFF) << 16)
                        | ((receivedData[i * 4 + 2] & 0xFF) << 8)
                        | (receivedData[i * 4 + 3] & 0xFF);
            }

            List<Integer> evenNumbers = new ArrayList<>();
            for (int num : numbers) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }

            byte[] responseData = new byte[evenNumbers.size() * 4];
            for (int i = 0; i < evenNumbers.size(); i++) {
                int num = evenNumbers.get(i);
                responseData[i * 4] = (byte) (num >> 24);
                responseData[i * 4 + 1] = (byte) (num >> 16);
                responseData[i * 4 + 2] = (byte) (num >> 8);
                responseData[i * 4 + 3] = (byte) (num);
            }

            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, data.getAddress(), data.getPort());
            socket.send(responsePacket);
        }
    }
}
