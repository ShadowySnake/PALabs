package optionalPackage.clientSide;

import optionalPackage.serverSide.SocialNetworkServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread
{
    private final Socket socket;
    private final SocialNetworkServer object;
    private String client = null;

    public ClientThread(Socket socket, SocialNetworkServer object) {
        this.socket = socket;
        this.object = object;
    }

    public void run()
    {
        try {
            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(input);
            String line;
            while ((line = in.readLine()) != null)
            {
                String[] command = line.split(" ");
                switch (command[0]) {
                    case "register":
                        if (client == null) {
                            if (!object.findInList(command[1])) {
                                object.addUser(command[1]);
                                writeToClient("Registered successfully!");
                            } else {
                                writeToClient("The user is already in the list!");
                            }
                        } else {
                            writeToClient("You may not register people while you are logged in!");
                        }
                        break;
                    case "login":
                        if (client == null) {
                            if (object.findInList(command[1])) {
                                client = command[1];
                                writeToClient("Successfully logged in!");
                            } else {
                                writeToClient("This user is not registered");
                            }
                        } else {
                            writeToClient("You are already logged in. You may not log in again!");
                        }
                        break;
                    case "friend":
                        if (client == null) {
                            writeToClient("You may not add friendships because you are not logged in!");
                        } else {
                            object.addFriendship(client, command[1]);
                            writeToClient("Friendship added!");
                        }
                        break;
                    case "message":
                        if (client == null) {
                            writeToClient("You may not send messages. You are not logged in!");
                        } else {
                            StringBuilder text = new StringBuilder(client + ": ");
                            for (int i = 1; i < command.length; ++i) {
                                text.append(" ").append(command[i]);
                            }
                            object.addMessage(client, text.toString());
                            writeToClient("Message added!");
                        }
                        break;
                    case "read":
                        if (client == null) {
                            writeToClient("You may not read your messages. You are not logged in!");
                        } else {
                            writeToClient(object.readMessage(client));
                        }
                        break;
                    case "stop":
                        writeToClient("Exitting...");
                        return;
                    default:
                        writeToClient("Unknown command.");
                        object.printNetwork();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToClient(String message) throws IOException {
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            out.println(message);
            out.flush();
    }
}
