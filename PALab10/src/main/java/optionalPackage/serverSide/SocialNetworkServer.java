package optionalPackage.serverSide;

import optionalPackage.clientSide.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocialNetworkServer
{
    public static List<String> listOfUsers = new ArrayList<>();
    public static List<Integer> numberOfFriends = new ArrayList<>();
    private final List<String> listOfMessages = new ArrayList<>();
    public static List<String> activeUsers = new ArrayList<>();
    public boolean acceptingUsers = true;
    private final int[][] matrix = new int[101][101];

    public SocialNetworkServer() throws IOException
    {
        activeUsers.add("Back");
        int PORT = 8100;
        ServerSocket serverSocket = new ServerSocket(PORT);
        serverSocket.setSoTimeout(15000);
        while (true)
        {
            /*if(acceptingUsers) { // this will only be used for testing
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");
                new ClientThread(socket, this).start();
                acceptingUsers = false; // i force the server to accept only one client
            }*/

            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");
            new ClientThread(socket, this).start();

            //System.out.println(activeUsers.size()); without this the server never closes for some reason

             if (activeUsers.size() == 0) {
                System.out.println("Server will stop soon...");
                break;
            }

        }
    }

    public void addUser(String user)
    {
        listOfUsers.add(user);
        numberOfFriends.add(0);
        listOfMessages.add("");
    }

    public void addActiveUser(String user){
        if(activeUsers.get(0).equals("Back")) activeUsers.remove("Back");
        activeUsers.add(user);
    }

    public void removeActiveUser(String user){
        activeUsers.remove(user);
    }

    public void addMessage(String from, String message)
    {
        int index = listOfUsers.indexOf(from);
        for(int j = 0; j < listOfUsers.size(); j++)
            if(matrix[index][j] == 1) {
                listOfMessages.add(j, listOfMessages.get(j) + message + "\n");
            }
    }

    public void addFriendship(String user1, String user2)
    {
        int index1 = listOfUsers.indexOf(user1);
        int index2 = listOfUsers.indexOf(user2);
        numberOfFriends.set(index1,numberOfFriends.get(index1) + 1);
        numberOfFriends.set(index2,numberOfFriends.get(index2) + 1);
        matrix[index1][index2] = 1;
        matrix[index2][index1] = 1;
    }

    public String readMessage(String name)
    {
        return listOfMessages.get(listOfUsers.indexOf(name));
    }

    public void printNetwork()
    {
        for (String listOfUser : listOfUsers) {
            System.out.println(listOfUser);
        }

        System.out.println();

        for (int i = 0; i < listOfUsers.size(); i++)
        {
            for (int j = 0; j < listOfUsers.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < listOfUsers.size(); i++) {
            System.out.println(listOfMessages.get(i));
        }
    }

    public boolean findInList(String name)
    {
        for(String user : listOfUsers) {
            if (user.equals(name)) {
                return true;
            }
        }
        return false;

    }

    public void allowOthers(){
        acceptingUsers = true;
    }

    public List<String> getActiveUsers() {
        return activeUsers;
    }

    public List<String> getListOfUsers(){
        return listOfUsers;
    }


    public static void main(String[] args) throws IOException {
            try {
                SocialNetworkServer ser = new SocialNetworkServer();
                PieChart demo = new PieChart( "Network Friendships", ser);
                demo.setSize( 560 , 367 );
                demo.setVisible( true );
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
