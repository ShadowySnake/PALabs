package compulsoryPackage.clientSide;

import compulsoryPackage.serverSide.SocialNetworkServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private SocialNetworkServer server;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void setServer(SocialNetworkServer server) {
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String request;
            while ((request = in.readLine()) != null) {
                String response = this.execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                out.flush();
                if (request.equalsIgnoreCase("stop")) this.server.stop();
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public String execute(String request) {
        System.out.println("Server received the request: " + request);
        if (request.equalsIgnoreCase("stop")) {
            System.out.println("Server will stop immediately...");
            return "Server has stopped!";
        }
        return "The command has been executed successfully!";
    }
}
