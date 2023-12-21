import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket to listen for incoming connections on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server listening on port 12345...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Create input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Continuously read and respond to messages
            while (true) {
                // Read data from the client
                String clientMessage = in.readLine();
                if (clientMessage == null) {
                    break; // Break the loop if the client disconnects
                }

                System.out.println("Client says: " + clientMessage);

                // Record the time before sending the response
                long startTime = System.currentTimeMillis();

                // Send a response back to the client
                out.println("Hello, client! I received your message.");

                // Record the time after sending the response
                long endTime = System.currentTimeMillis();

                // Calculate and print the message transmission time
                long messageTime = endTime - startTime;
                System.out.println("Message transmission time: " + messageTime + " milliseconds");
            }

            // Close the connections
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
