import java.io.*;
import java.net.Socket;

/**
 * Created by ylc265 on 10/24/15.
 */
public abstract class VaranoiClient {
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Socket socket;
    String server, username;
    private int port;

    VaranoiClient(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    public boolean start() {
        try {
            socket = new Socket(server, port);
        } catch(Exception ec) {
            System.out.println("Error connecting to server: " + ec);
            return false;
        }
        System.out.println("Connect accepted " + socket.getInetAddress() + ":" + socket.getPort());
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException eIO) {
            System.out.println("Exception creating new Input/Output Streams: " + eIO);
            return false;
        }
        System.out.println("Starting game");
        String command;
        try {
            char[] al = new char[20];
            while (true) {
                in.read(al);
                command = new String(al).split("\0")[0];
                out.println(process(command));
            }
        } catch (IOException eIO) {
            System.out.println(eIO.getMessage());
        }
        return true;
    }

    public abstract String process(String command);
}
