package hu.dpc.edu.javase.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class ChatClientHandler implements Runnable, ChatClient {

    private final Socket conn;
    private final ChatRouter router;
    private PrintWriter out;

    public ChatClientHandler(Socket connection, ChatRouter router) {
        this.conn = connection;
        this.router = router;
    }

    @Override
    public void run() {
        System.out.println("Connected: " + conn.getInetAddress());
        try {
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            send("Hello, dear guest, logged in from: " + conn.getInetAddress());
            router.registerClient(this);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("line: " + line);
                    router.broadcast(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            router.unregisterClient(this);
            try {
                conn.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public synchronized void send(String message) {
        if (out != null) {
            out.println(message);
            out.flush();
        }
    }

    @Override
    public String getName() {
        return conn.getRemoteSocketAddress().toString();
    }
}
