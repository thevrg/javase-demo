package hu.dpc.edu.javase.demo.net;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author IQJB
 */
public class SocketDemo {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("index.hu", 80);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));) {
            out.println("GET / HTTP/1.1");
            out.println("Host: index.hu");
            out.println();
            out.flush();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"))) {
                String line;
                while((line = reader.readLine())!= null) {
                    System.out.println(line);
                }
            }
        }
    }
}
