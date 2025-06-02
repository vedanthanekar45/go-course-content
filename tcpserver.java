import java.io.*;
import java.net.*;

public class tcpserver {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String messageFromClient;
            while ((messageFromClient = in.readLine()) != null) {
                System.out.println("Message from client: " + messageFromClient);
                out.println("Server received: " + messageFromClient);
                if (messageFromClient.equalsIgnoreCase("exit")) break;
                out.println("Echo: " + messageFromClient);
            }
            // clientSocket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}