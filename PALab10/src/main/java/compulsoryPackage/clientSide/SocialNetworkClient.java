package compulsoryPackage.clientSide;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocialNetworkClient {
    Socket socket;

    public SocialNetworkClient() throws IOException {
        String SERVER_ADDRESS = "127.0.0.1";
        int PORT = 8100;
        this.socket = new Socket(SERVER_ADDRESS, PORT);
    }

    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else if (request.equalsIgnoreCase("stop")) {
                client.sendRequestToServer(request);
                client.receiveResponseFromServer();
                System.out.println("Client will also stop.");
                break;
            } else {
                client.sendRequestToServer(request);
                client.receiveResponseFromServer();
            }
        }
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void sendRequestToServer(String request) throws IOException {
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter out = new BufferedWriter(output);
        out.write(request + "\n");
        out.flush();
    }

    private void receiveResponseFromServer() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String rsp = in.readLine();
        if (rsp != null) {
            System.out.println(rsp);
        }
    }
}
