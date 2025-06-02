import java.io.*;
import java.net.*;
import java.util.Scanner;

public class tcpclient {
    public static void main(String[] args) {
        String address = "localhost";
        int host = 5000;

        try (Socket socket = new Socket(address, host)) {
            System.out.println("Connected to server at " + address + " on port " + host);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            String userInput;
            while (true) {
                System.out.print("Enter message (type 'exit' to close the connection): ");
                userInput = scanner.nextLine();
                out.println(userInput);
                System.out.println(userInput);
                if (userInput.equalsIgnoreCase("exit")) break;
                
                String responseFromServer = in.readLine();
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}