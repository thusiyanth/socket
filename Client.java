import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 12345
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server on port 12345...");

            // Create input and output streams for communication with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create a BufferedReader to read user input from the console
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Continuously send messages to the server
            while (true) {
                // Read a message from the user
                System.out.print("Type a message to send to the server: ");
                String message = userInput.readLine();

                // Record the time before sending the message
                long startTime = System.currentTimeMillis();

                // Send the message to the server
                out.println(message);

                // Receive and print the server's response
                String serverResponse = in.readLine();
                if (serverResponse == null) {
                    break; // Break the loop if the server disconnects
                }

                System.out.println("Server says: " + serverResponse);

                // Record the time after receiving the response
                long endTime = System.currentTimeMillis();

                // Calculate and print the message transmission time
                long messageTime = endTime - startTime;
                System.out.println("Message transmission time: " + messageTime + " milliseconds");
            }

            // Close the connections
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
