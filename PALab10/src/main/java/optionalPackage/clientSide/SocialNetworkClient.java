package optionalPackage.clientSide;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocialNetworkClient
{

    public SocialNetworkClient() throws IOException {
            int PORT = 8100;
            String SERVER_ADDRESS = "127.0.0.1";
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            Scanner scanner = new Scanner(System.in);
            OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter out = new BufferedWriter(output);

            String text;
            while(true)
            {
                text = scanner.nextLine();
                out.write(text + "\n");
                out.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                msg=in.readLine();
                System.out.println(msg);
                if (msg.equals("Exiting...")) break;
            }
    }

    public static void main(String[] args) throws IOException {
        try {
            new SocialNetworkClient();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}