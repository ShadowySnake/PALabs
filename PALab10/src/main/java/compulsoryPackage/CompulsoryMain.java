package compulsoryPackage;

import compulsoryPackage.serverSide.SocialNetworkServer;

import java.io.IOException;

public class CompulsoryMain {
    public static void main(String[] args) throws IOException {

        SocialNetworkServer server = new SocialNetworkServer();
        try {
            server.init();
            server.waitForClients();
        } catch (IOException e) {
            server.stop();
            System.out.println("Exception: " + e);
        }

    }
}
