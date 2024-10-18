package NetworkingSockets;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8080;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            java.net.Socket client = new java.net.Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            java.io.OutputStream outToServer = client.getOutputStream();
            java.io.DataOutputStream out = new java.io.DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            java.io.InputStream inFromServer = client.getInputStream();
            java.io.DataInputStream in = new java.io.DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
