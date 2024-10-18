package NetworkingSockets;

public class GreetingServer extends Thread{
    private java.net.ServerSocket serverSocket;

    public GreetingServer(int port) throws java.io.IOException {
        serverSocket = new java.net.ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                java.net.Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                java.io.DataInputStream in = new java.io.DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                java.io.DataOutputStream out = new java.io.DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (java.net.SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (java.io.IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        try {
            Thread t = new GreetingServer(port);
            t.start();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
