import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class udpserver {
    public static void main (String args[]) throws Exception {
        int port = 3000;
        DatagramSocket server = new DatagramSocket(port);
        byte[] receiveBuffer = new byte[1024];

        Scanner scanner = new Scanner(System.in);
        System.out.println("UDP Server is listening on port " + port);

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            server.receive(receivePacket);

            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMessage);

             if (clientMessage.equalsIgnoreCase("exit")) {
                System.out.println("Client closed the connection. Exiting..");
                break;
            }
            
            System.out.print("Enter your message: ");
            String reply = scanner.nextLine();
            byte[] sendBuffer = reply.getBytes();

            DatagramPacket sendPacket = new DatagramPacket (
                sendBuffer,
                sendBuffer.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
            );

            server.send(sendPacket);
        }
    }
}