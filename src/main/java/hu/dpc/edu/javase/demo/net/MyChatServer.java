/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author IQJB
 */
public class MyChatServer {

    private int port;
    
    private ChatRouter router;

    public MyChatServer(int port, ChatRouter router) {
        this.port = port;
        this.router = router;
    }

    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Started MyChatServer on port " + port);
        while (true) {
            Socket socket = ss.accept();
            ChatClientHandler clientHandler = new ChatClientHandler(socket, router);
            Thread t = new Thread(clientHandler);
            t.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new MyChatServer(8888, new ChatRouterImpl()).start();
    }
}
