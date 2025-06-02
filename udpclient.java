import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpclient {
    public static void main (String args[]) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAdd = InetAddress.getByName("localhost");

        int port = 3000;
        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            System.out.print("Enter message (type 'exit' to quit): ");
            message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) break;

            byte[] sendBuffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAdd, port);
            client.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            client.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server says: " + response);
        }
        client.close();
        scanner.close();
    } 
}